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

import upeu.edu.pe.CareerClimb.Entity.Evaluacion;
import upeu.edu.pe.CareerClimb.Service.EvaluacionService;

@RestController
@RequestMapping("/api/evaluaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public ResponseEntity<List<Evaluacion>> getAll() {
        try {
            List<Evaluacion> e = evaluacionService.getAll();
            if (e.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(e, HttpStatus.OK);
        } catch (Exception ex) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> getById(@PathVariable("id") Long id) {
        try {
            Evaluacion e = evaluacionService.getById(id).get();
            return new ResponseEntity<>(e, HttpStatus.OK);
        } catch (Exception ex) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Evaluacion> create(@Validated @RequestBody Evaluacion evaluacion) {
        try {
            Evaluacion e = evaluacionService.create(evaluacion);
            return new ResponseEntity<>(e, HttpStatus.CREATED);
        } catch (Exception ex) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody Evaluacion evaluacion) {
        Evaluacion e = evaluacionService.getById(id).get();
        if (e.getIdEvaluacion() > 0) {
            return new ResponseEntity<>(evaluacionService.update(evaluacion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Evaluacion> delete(@PathVariable("id") Long id) {
        try {
            evaluacionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
