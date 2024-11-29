package upeu.edu.pe.CareerClimb.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import upeu.edu.pe.CareerClimb.dto.ResponseDocDTO;

public interface DocService {
    // Método para almacenar un documento con referencia a un detalle específico
	void store(MultipartFile file, String nombreDetalle, String motivoRechazo, String estado, char isActive, Long idDetallePPP) throws IOException;

    // Método para obtener el documento completo en formato binario (vista previa o descarga)
    Optional<byte[]> getDocumentContent(Long id) throws FileNotFoundException;

    // Método para obtener los metadatos de un documento
    Optional<ResponseDocDTO> getDocumentMetadata(Long id) throws FileNotFoundException;

    // Método para obtener todos los metadatos de los documentos almacenados
    List<ResponseDocDTO> getAllDocuments();

    // Método para eliminar un documento por su ID
    void deleteDocument(Long id) throws FileNotFoundException;
}
