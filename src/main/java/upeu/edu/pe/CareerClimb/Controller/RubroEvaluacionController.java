package upeu.edu.pe.CareerClimb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import upeu.edu.pe.CareerClimb.Entity.RubroEvaluacion;
import upeu.edu.pe.CareerClimb.Service.RubroEvaluacionService;

@RestController
@RequestMapping("/api/rubro-evaluacion")
@CrossOrigin(origins = "http://localhost:4200")
public class RubroEvaluacionController {

    @Autowired
    private RubroEvaluacionService rubroEvaluacionService;

    @GetMapping
    public ResponseEntity<List<RubroEvaluacion>> getAll() {
        try {
            List<RubroEvaluacion> rubros = rubroEvaluacionService.getAll();
            if (rubros.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(rubros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RubroEvaluacion> getById(@PathVariable("id") Long id) {
        try {
            RubroEvaluacion rubro = rubroEvaluacionService.getById(id).orElse(null);
            if (rubro != null) {
                return new ResponseEntity<>(rubro, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<RubroEvaluacion> create(@Validated @RequestBody RubroEvaluacion rubroEvaluacion) {
        try {
            RubroEvaluacion rubro = rubroEvaluacionService.create(rubroEvaluacion);
            return new ResponseEntity<>(rubro, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody RubroEvaluacion rubroEvaluacion) {
        try {
            RubroEvaluacion existingRubro = rubroEvaluacionService.getById(id).orElse(null);
            if (existingRubro != null) {
                RubroEvaluacion updatedRubro = rubroEvaluacionService.update(rubroEvaluacion);
                return new ResponseEntity<>(updatedRubro, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            rubroEvaluacionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

