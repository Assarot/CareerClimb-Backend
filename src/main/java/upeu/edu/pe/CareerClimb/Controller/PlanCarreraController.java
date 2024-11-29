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

import upeu.edu.pe.CareerClimb.Entity.PlanCarrera;
import upeu.edu.pe.CareerClimb.Service.PlanCarreraService;

@RestController
@RequestMapping("/api/plan-carreras")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanCarreraController {
    @Autowired
    private PlanCarreraService planCarreraService;

    @GetMapping
    public ResponseEntity<List<PlanCarrera>> getAll() {
        try {
            List<PlanCarrera> p = planCarreraService.getAll();
            if (p.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanCarrera> getById(@PathVariable("id") Long id) {
        try {
            PlanCarrera p = planCarreraService.getById(id).get();
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<PlanCarrera> create(@Validated @RequestBody PlanCarrera planCarrera) {
        try {
            PlanCarrera p = planCarreraService.create(planCarrera);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody PlanCarrera planCarrera) {
        PlanCarrera p = planCarreraService.getById(id).get();
        if (p.getIdPlanCarrera() > 0) {
            return new ResponseEntity<>(planCarreraService.update(planCarrera), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlanCarrera> delete(@PathVariable("id") Long id) {
        try {
            planCarreraService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
