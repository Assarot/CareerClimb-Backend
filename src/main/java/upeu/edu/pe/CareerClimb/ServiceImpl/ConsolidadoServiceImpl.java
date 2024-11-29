package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import upeu.edu.pe.CareerClimb.Entity.Consolidado;
import upeu.edu.pe.CareerClimb.Entity.PPP;
import upeu.edu.pe.CareerClimb.Repository.ConsolidadoRepository;
import upeu.edu.pe.CareerClimb.Repository.PPPRepository;
import upeu.edu.pe.CareerClimb.Service.ConsolidadoService;
import upeu.edu.pe.CareerClimb.dto.ReponseFileDTO;

@Service
public class ConsolidadoServiceImpl implements ConsolidadoService{
	
	@Autowired
    private ConsolidadoRepository consolidadoRepository;
	
	@Autowired
	private PPPRepository pppRepository;
	
	@Override
	public Consolidado store(MultipartFile file, Long detallePPPId) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        PPP ppp;

        // Verificar si el detallePPPId es proporcionado o no
        if (detallePPPId != null) {
            // Busca el DetallePPP por su ID
        	ppp = pppRepository.findById(detallePPPId)
                .orElseThrow(() -> new IllegalArgumentException("DetallePPP no encontrado con id: " + detallePPPId));
        } else {
            // Si no se proporciona detallePPPId, crea un nuevo Detalle_PPP automáticamente
        	ppp = new PPP();
        	ppp = pppRepository.save(ppp);
        }

        // Construye y guarda el Consolidado asociado con el DetallePPP
        Consolidado consolidado = Consolidado.builder()
                .nombre(fileName)
                .tipo(file.getContentType())
                .data(file.getBytes())
                .ppp(ppp) // Asociamos el DetallePPP
                .build();

        return consolidadoRepository.save(consolidado);
	}

	@Override
    public Optional<Consolidado> getFile(Long id) throws FileNotFoundException {
        return consolidadoRepository.findById(id);
    }


	@Override
	public Optional<ReponseFileDTO> getFileMetadata(Long id) throws FileNotFoundException {
		return consolidadoRepository.findById(id).map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/fileManager/files/")
                    .path(dbFile.getId().toString())
                    .toUriString();

            return ReponseFileDTO.builder()
                    .id(dbFile.getId())
                    .name(dbFile.getNombre())
                    .url(fileDownloadUri)
                    .type(dbFile.getTipo())
                    .size(dbFile.getData().length)
                    .idPPP(dbFile.getPpp() != null ? dbFile.getPpp().getIdPPP() : null)
                    .fechaSubida(dbFile.getFechaSubida().toString()) // Incluir fechaSubida
                    .build();
        });
	}

	@Override
	public List<ReponseFileDTO> getAllFile() {
	    // Recupera todos los archivos del repositorio
	    return consolidadoRepository.findAll().stream().map(dbFile -> {
	        // Construye la URL de descarga del archivo
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/api/fileManager/files/")
	                .path(dbFile.getId().toString())
	                .toUriString();

	        // Mapea cada archivo Consolidado al DTO ReponseFileDTO
	        return ReponseFileDTO.builder()
	                .id(dbFile.getId()) // ID del archivo
	                .name(dbFile.getNombre()) // Nombre del archivo
	                .url(fileDownloadUri) // URL del archivo
	                .type(dbFile.getTipo()) // Tipo de archivo (MIME)
	                .size(dbFile.getData() != null ? dbFile.getData().length : 0) // Tamaño del archivo
	                .idPPP(dbFile.getPpp() != null ? dbFile.getPpp().getIdPPP() : null) // ID del DetallePPP si existe
	                .fechaSubida(dbFile.getFechaSubida() != null ? dbFile.getFechaSubida().toString() : null) // Fecha de subida
	                .build();
	    }).collect(Collectors.toList());
	}


	@Override
	public void deleteFile(Long id) throws FileNotFoundException {
		if (!consolidadoRepository.existsById(id)) {
            throw new FileNotFoundException("Archivo no encontrado con el id: " + id);
        }
        consolidadoRepository.deleteById(id);
	}

	

}
