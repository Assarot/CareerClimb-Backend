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

import upeu.edu.pe.CareerClimb.Entity.DetallePPP;
import upeu.edu.pe.CareerClimb.Service.DetallePPPService;

@RestController
@RequestMapping("/api/detalle-ppp")
@CrossOrigin(origins = "http://localhost:4200")
public class DetallePPPController {
    @Autowired
    private DetallePPPService detallePPPService;

    @GetMapping
    public ResponseEntity<List<DetallePPP>> getAll() {
        try {
            List<DetallePPP> d = detallePPPService.getAll();
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
    public ResponseEntity<DetallePPP> getById(@PathVariable("id") Long id) {
        try {
            DetallePPP d = detallePPPService.getById(id).get();
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<DetallePPP> create(@Validated @RequestBody DetallePPP detallePPP) {
        try {
            DetallePPP d = detallePPPService.create(detallePPP);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody DetallePPP detallePPP) {
        DetallePPP d = detallePPPService.getById(id).get();
        if (d.getIdDetallePPP() > 0) {
            return new ResponseEntity<>(detallePPPService.update(detallePPP), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetallePPP> delete(@PathVariable("id") Long id) {
        try {
            detallePPPService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
