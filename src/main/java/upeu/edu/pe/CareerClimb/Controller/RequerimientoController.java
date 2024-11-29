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

import upeu.edu.pe.CareerClimb.Entity.Requerimiento;
import upeu.edu.pe.CareerClimb.Service.RequerimientoService;

@RestController
@RequestMapping("/api/requerimientos")
@CrossOrigin(origins = "http://localhost:4200")
public class RequerimientoController {
    @Autowired
    private RequerimientoService requerimientoService;

    @GetMapping
    public ResponseEntity<List<Requerimiento>> getAll() {
        try {
            List<Requerimiento> r = requerimientoService.getAll();
            if (r.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(r, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Requerimiento> getById(@PathVariable("id") Long id) {
        try {
            Requerimiento r = requerimientoService.getById(id).get();
            return new ResponseEntity<>(r, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Requerimiento> create(@Validated @RequestBody Requerimiento requerimiento) {
        try {
            Requerimiento r = requerimientoService.create(requerimiento);
            return new ResponseEntity<>(r, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody Requerimiento requerimiento) {
        Requerimiento r = requerimientoService.getById(id).get();
        if (r.getIdRequerimiento() > 0) {
            return new ResponseEntity<>(requerimientoService.update(requerimiento), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Requerimiento> delete(@PathVariable("id") Long id) {
        try {
            requerimientoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
