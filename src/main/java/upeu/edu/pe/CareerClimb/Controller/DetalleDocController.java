package upeu.edu.pe.CareerClimb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.CareerClimb.Entity.DetalleDoc;
import upeu.edu.pe.CareerClimb.Service.DetalleDocService;

@RestController
@RequestMapping("/api/detalle-docs")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleDocController {
    @Autowired
    private DetalleDocService detalleDocService;

    @GetMapping
    public ResponseEntity<List<DetalleDoc>> getAll() {
        try {
            List<DetalleDoc> d = detalleDocService.getAll();
            if (d.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleDoc> getById(@PathVariable("id") Long id) {
        try {
            DetalleDoc d = detalleDocService.getById(id).get();
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<DetalleDoc> create(@Validated @RequestBody DetalleDoc detalleDoc) {
        try {
            DetalleDoc d = detalleDocService.create(detalleDoc);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody DetalleDoc detalleDoc) {
        DetalleDoc d = detalleDocService.getById(id).get();
        if (d.getIdDetalleDoc() > 0) {
            return new ResponseEntity<>(detalleDocService.update(detalleDoc), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetalleDoc> delete(@PathVariable("id") Long id) {
        try {
            detalleDocService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
