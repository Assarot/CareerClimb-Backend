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

import upeu.edu.pe.CareerClimb.Entity.AccesoRol;
import upeu.edu.pe.CareerClimb.Service.AccesoRolService;

@RestController
@RequestMapping("/api/accesos-rol")
public class AccesoRolController {
    @Autowired
    private AccesoRolService accesoRolService;

    @GetMapping
    public ResponseEntity<List<AccesoRol>> getAll() {
        try {
            List<AccesoRol> ar = accesoRolService.getAll();
            if (ar.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ar, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccesoRol> getById(@PathVariable("id") Long id) {
        try {
            AccesoRol ar = accesoRolService.getById(id).get();
            return new ResponseEntity<>(ar, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<AccesoRol> create(@Validated @RequestBody AccesoRol accesoRol) {
        try {
            AccesoRol ac = accesoRolService.create(accesoRol);
            return new ResponseEntity<>(ac, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccesoRol> update(@PathVariable("id") Long id, @Validated @RequestBody AccesoRol accesoRol) {
        AccesoRol ar = accesoRolService.getById(id).get();
        if (ar.getIdAccesoRol() > 0) {
            return new ResponseEntity<>(accesoRolService.update(accesoRol), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccesoRol> delete(@PathVariable("id") Long id) {
        try {
            accesoRolService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
