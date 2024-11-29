package upeu.edu.pe.CareerClimb.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import upeu.edu.pe.CareerClimb.Service.DocService;
import upeu.edu.pe.CareerClimb.dto.ResponseDocDTO;
import upeu.edu.pe.CareerClimb.dto.ResponseMessage;

@RestController
@RequestMapping("/api/docManager")
@CrossOrigin(origins = "http://localhost:4200")
public class DocController {

    @Autowired
    private DocService docService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadDocument(
            @RequestParam("file") MultipartFile file,
            @RequestParam("nombreDetalle") String nombreDetalle,
            @RequestParam(value = "motivoRechazo", required = false) String motivoRechazo,
            @RequestParam("estado") String estado,
            @RequestParam("isActive") char isActive,
            @RequestParam(value = "idDetallePPP", required = false) Long idDetallePPP) throws IOException {

        // Llamar al servicio para almacenar el documento
        docService.store(file, nombreDetalle, motivoRechazo, estado, isActive, idDetallePPP);

        return ResponseEntity.ok(Map.of("message", "Archivo y Detalle creados exitosamente."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable Long id) throws FileNotFoundException {
        // Obtener el contenido del archivo
        byte[] content = docService.getDocumentContent(id)
                .orElseThrow(() -> new FileNotFoundException("Archivo no encontrado"));

        // Obtener los metadatos del documento
        Optional<ResponseDocDTO> optionalDoc = docService.getDocumentMetadata(id);

        // Determinar el tipo MIME, por defecto `APPLICATION_OCTET_STREAM`
        MediaType mediaType = optionalDoc.map(doc -> MediaType.parseMediaType(doc.getTipo()))
                                         .orElse(MediaType.APPLICATION_OCTET_STREAM);

        return ResponseEntity.ok()
                .contentType(mediaType) // Usar el tipo MIME obtenido o el predeterminado
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"archivo_" + id + "\"")
                .body(new ByteArrayResource(content));
    }


    @GetMapping("/metadata/{id}")
    public ResponseEntity<ResponseDocDTO> getMetadata(@PathVariable Long id) throws FileNotFoundException {
        ResponseDocDTO metadata = docService.getDocumentMetadata(id).orElseThrow(() -> new FileNotFoundException("Documento no encontrado"));
        return ResponseEntity.ok(metadata);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseDocDTO>> getAllDocuments() {
        return ResponseEntity.ok(docService.getAllDocuments());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long id) throws FileNotFoundException {
        docService.deleteDocument(id);
        return ResponseEntity.ok("Documento eliminado exitosamente.");
    }
}
