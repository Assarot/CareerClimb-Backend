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

import upeu.edu.pe.CareerClimb.Entity.Rubro;
import upeu.edu.pe.CareerClimb.Service.RubroService;

@RestController
@RequestMapping("/api/rubros")
@CrossOrigin(origins = "http://localhost:4200")
public class RubroController {
    @Autowired
    private RubroService rubroService;

    @GetMapping
    public ResponseEntity<List<Rubro>> getAll() {
        try {
            List<Rubro> r = rubroService.getAll();
            if (r.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(r, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rubro> getById(@PathVariable("id") Long id) {
        try {
            Rubro r = rubroService.getById(id).get();
            return new ResponseEntity<>(r, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Rubro> create(@Validated @RequestBody Rubro rubro) {
        try {
            Rubro r = rubroService.create(rubro);
            return new ResponseEntity<>(r, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody Rubro rubro) {
        Rubro r = rubroService.getById(id).get();
        if (r.getIdRubro() > 0) {
            return new ResponseEntity<>(rubroService.update(rubro), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rubro> delete(@PathVariable("id") Long id) {
        try {
            rubroService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
