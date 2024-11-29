package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import upeu.edu.pe.CareerClimb.Entity.Doc;
import upeu.edu.pe.CareerClimb.Entity.DetalleDoc;
import upeu.edu.pe.CareerClimb.Entity.DetallePPP;
import upeu.edu.pe.CareerClimb.Repository.DetalleDocRepository;
import upeu.edu.pe.CareerClimb.Repository.DocRepository;
import upeu.edu.pe.CareerClimb.Service.DocService;
import upeu.edu.pe.CareerClimb.dto.ResponseDocDTO;

@Service
public class DocServiceImpl implements DocService {

    private final static String UPLOADS_FOLDER = System.getProperty("user.home") + "/Documentos/subidos/";

    @Autowired
    private DocRepository docRepository;
    
    @Autowired
    private DetalleDocRepository detalleDocRepository;

    @Override
    public void store(MultipartFile file, String nombreDetalle, String motivoRechazo, String estado, char isActive, Long idDetallePPP) throws IOException {
        // 1. Crear y guardar el DetalleDoc
        DetalleDoc detalleDoc = new DetalleDoc();
        detalleDoc.setNombre(nombreDetalle);
        detalleDoc.setMotivoRechazo(motivoRechazo);
        detalleDoc.setEstado(estado);
        detalleDoc.setIsActive(isActive);
        
        // Asociar con DetallePPP si el ID es proporcionado
        if (idDetallePPP != null) {
            DetallePPP detallePPP = new DetallePPP(); // Crear un objeto temporal con el ID
            detallePPP.setIdDetallePPP(idDetallePPP);
            detalleDoc.setDetallePPP(detallePPP);
        }

        // Guardar el DetalleDoc en la base de datos
        detalleDoc = detalleDocRepository.save(detalleDoc);

        // 2. Crear la carpeta de almacenamiento si no existe
        Path folderPath = Paths.get(UPLOADS_FOLDER);
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        // 3. Generar un nombre único para el archivo
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        // 4. Crear la ruta completa para el archivo
        Path filePath = folderPath.resolve(uniqueFileName);
        Files.copy(file.getInputStream(), filePath);

        // 5. Crear y guardar la entidad Doc
        Doc doc = Doc.builder()
                .nombre(file.getOriginalFilename())  // Nombre original del archivo
                .tipo(file.getContentType())        // Tipo MIME del archivo
                .ruta(filePath.toString())          // Ruta donde se almacenó
                .detalleDoc(detalleDoc)             // Asociar con el DetalleDoc recién creado
                .build();

        // Guardar en la base de datos
        docRepository.save(doc);
    }

    @Override
    public Optional<byte[]> getDocumentContent(Long id) throws FileNotFoundException {
        // Buscar el documento en la base de datos
        Doc doc = docRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("Documento no encontrado con ID: " + id));

        // Leer el archivo desde el sistema de archivos
        File file = new File(doc.getRuta());
        if (!file.exists() || !file.canRead()) {
            throw new FileNotFoundException("Archivo no encontrado o no legible en la ruta: " + doc.getRuta());
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            return Optional.of(fis.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public Optional<ResponseDocDTO> getDocumentMetadata(Long id) throws FileNotFoundException {
        // Buscar documento en la base de datos
        Doc doc = docRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("Documento no encontrado con ID: " + id));

        // Convertir la entidad Doc a ResponseDocDTO
        ResponseDocDTO dto = new ResponseDocDTO(doc.getId(), doc.getNombre(), doc.getTipo(), doc.getRuta());
        return Optional.of(dto);
    }

    @Override
    public List<ResponseDocDTO> getAllDocuments() {
        // Obtener todos los documentos y convertirlos a DTO
        return docRepository.findAll().stream()
                .map(doc -> new ResponseDocDTO(doc.getId(), doc.getNombre(), doc.getTipo(), doc.getRuta()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDocument(Long id) throws FileNotFoundException {
        // Buscar el documento en la base de datos
        Doc doc = docRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("Documento no encontrado con ID: " + id));

        // Eliminar el archivo del sistema de archivos
        File file = new File(doc.getRuta());
        if (file.exists() && !file.delete()) {
            throw new RuntimeException("No se pudo eliminar el archivo en la ruta: " + doc.getRuta());
        }

        // Eliminar la referencia en la base de datos
        docRepository.deleteById(id);
    }
}
