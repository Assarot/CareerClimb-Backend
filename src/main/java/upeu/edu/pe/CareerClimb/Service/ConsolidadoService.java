package upeu.edu.pe.CareerClimb.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import upeu.edu.pe.CareerClimb.Entity.Consolidado;
import upeu.edu.pe.CareerClimb.dto.ReponseFileDTO;

public interface ConsolidadoService {
	Consolidado store(MultipartFile file, Long detallePPPId) throws IOException, java.io.IOException;

    // Método para obtener el archivo en formato binario (para vista previa o descarga)
    Optional<Consolidado> getFile(Long id) throws FileNotFoundException;

    // Método para obtener solo los metadatos del archivo
    Optional<ReponseFileDTO> getFileMetadata(Long id) throws FileNotFoundException;

    List<ReponseFileDTO> getAllFile();
    
    void deleteFile(Long id) throws FileNotFoundException;
}
