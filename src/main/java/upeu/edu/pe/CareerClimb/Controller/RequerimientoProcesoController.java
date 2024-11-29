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

import upeu.edu.pe.CareerClimb.Entity.RequerimientoProceso;
import upeu.edu.pe.CareerClimb.Service.RequerimientoProcesoService;

@RestController
@RequestMapping("/api/requerimiento-procesos")
@CrossOrigin(origins = "http://localhost:4200")
public class RequerimientoProcesoController {
    @Autowired
    private RequerimientoProcesoService requerimientoProcesoService;

    @GetMapping
    public ResponseEntity<List<RequerimientoProceso>> getAll() {
        try {
            List<RequerimientoProceso> r = requerimientoProcesoService.getAll();
            if (r.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(r, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequerimientoProceso> getById(@PathVariable("id") Long id) {
        try {
            RequerimientoProceso r = requerimientoProcesoService.getById(id).get();
            return new ResponseEntity<>(r, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<RequerimientoProceso> create(@Validated @RequestBody RequerimientoProceso requerimientoProceso) {
        try {
            RequerimientoProceso r = requerimientoProcesoService.create(requerimientoProceso);
            return new ResponseEntity<>(r, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody RequerimientoProceso requerimientoProceso) {
        RequerimientoProceso r = requerimientoProcesoService.getById(id).get();
        if (r.getIdRequerimientoProceso() > 0) {
            return new ResponseEntity<>(requerimientoProcesoService.update(requerimientoProceso), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RequerimientoProceso> delete(@PathVariable("id") Long id) {
        try {
            requerimientoProcesoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
