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

import upeu.edu.pe.CareerClimb.Entity.DetalleEvaluacion;
import upeu.edu.pe.CareerClimb.Service.DetalleEvaluacionService;

@RestController
@RequestMapping("/api/detalle-evaluaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleEvaluacionController {
    @Autowired
    private DetalleEvaluacionService detalleEvaluacionService;

    @GetMapping
    public ResponseEntity<List<DetalleEvaluacion>> getAll() {
        try {
            List<DetalleEvaluacion> d = detalleEvaluacionService.getAll();
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
    public ResponseEntity<DetalleEvaluacion> getById(@PathVariable("id") Long id) {
        try {
            DetalleEvaluacion d = detalleEvaluacionService.getById(id).get();
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<DetalleEvaluacion> create(@Validated @RequestBody DetalleEvaluacion detalleEvaluacion) {
        try {
            DetalleEvaluacion d = detalleEvaluacionService.create(detalleEvaluacion);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody DetalleEvaluacion detalleEvaluacion) {
        DetalleEvaluacion d = detalleEvaluacionService.getById(id).get();
        if (d.getIdDetalleEvaluacion() > 0) {
            return new ResponseEntity<>(detalleEvaluacionService.update(detalleEvaluacion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetalleEvaluacion> delete(@PathVariable("id") Long id) {
        try {
            detalleEvaluacionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
