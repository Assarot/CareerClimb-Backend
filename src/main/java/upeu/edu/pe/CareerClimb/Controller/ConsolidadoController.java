package upeu.edu.pe.CareerClimb.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import upeu.edu.pe.CareerClimb.Entity.Consolidado;
import upeu.edu.pe.CareerClimb.Service.ConsolidadoService;
import upeu.edu.pe.CareerClimb.dto.ResponseMessage;
import upeu.edu.pe.CareerClimb.dto.ReponseFileDTO;

@RestController
@RequestMapping("/api/fileManager")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsolidadoController {
	@Autowired
    private ConsolidadoService consolidadoService;

    @PostMapping("/upload")
    public ResponseEntity<List<ResponseMessage>> uploadFiles(
            @RequestParam("file") List<MultipartFile> files,
            @RequestParam(value = "detallePPPId", required = false) Long detallePPPId) { // Hacer detallePPPId opcional
        List<ResponseMessage> responses = files.stream().map(file -> {
            try {
                consolidadoService.store(file, detallePPPId); // Pasamos el detallePPPId (puede ser null)
                return new ResponseMessage("Archivo '" + file.getOriginalFilename() + "' subido exitosamente");
            } catch (IOException e) {
                return new ResponseMessage("Error al subir archivo '" + file.getOriginalFilename() + "': " + e.getMessage());
            }
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    // Endpoint para obtener solo los metadatos del archivo
    @GetMapping("/files/{id}")
    public ResponseEntity<ReponseFileDTO> getFileMetadata(@PathVariable Long id) throws FileNotFoundException {
    	ReponseFileDTO responseFileDTO = consolidadoService.getFileMetadata(id)
                .orElseThrow(() -> new FileNotFoundException("Archivo no encontrado con el id: " + id));

        return ResponseEntity.status(HttpStatus.OK).body(responseFileDTO);
    }

    // Endpoint para obtener el contenido binario del archivo para visualización o descarga
    @GetMapping("/files/view/{id}")
    public ResponseEntity<Resource> viewFile(@PathVariable Long id) throws FileNotFoundException {
        Consolidado file = consolidadoService.getFile(id)
                .orElseThrow(() -> new FileNotFoundException("Archivo no encontrado con el id: " + id));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getTipo()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getNombre() + "\"")
                .body(new ByteArrayResource(file.getData()));
    }

    @GetMapping("/files")
    public ResponseEntity<List<ReponseFileDTO>> getListFiles() {
        List<ReponseFileDTO> files = consolidadoService.getAllFile();
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @DeleteMapping("/files/{id}")
    public ResponseEntity<ResponseMessage> deleteFile(@PathVariable Long id) {
        try {
            consolidadoService.deleteFile(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Archivo eliminado exitosamente"));
        } catch (FileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(e.getMessage()));
        }
    }
}
