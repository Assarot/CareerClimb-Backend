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

import upeu.edu.pe.CareerClimb.Entity.UsuarioRol;
import upeu.edu.pe.CareerClimb.Service.UsuarioRolService;

@RestController
@RequestMapping("/api/usuario-roles")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioRolController {
    @Autowired
    private UsuarioRolService usuarioRolService;

    @GetMapping
    public ResponseEntity<List<UsuarioRol>> getAll() {
        try {
            List<UsuarioRol> ur = usuarioRolService.getAll();
            if (ur.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ur, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRol> getById(@PathVariable("id") Long id) {
        try {
            UsuarioRol ur = usuarioRolService.getById(id).get();
            return new ResponseEntity<>(ur, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioRol> create(@Validated @RequestBody UsuarioRol usuarioRol) {
        try {
            UsuarioRol ur = usuarioRolService.create(usuarioRol);
            return new ResponseEntity<>(ur, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody UsuarioRol usuarioRol) {
        UsuarioRol ur = usuarioRolService.getById(id).get();
        if (ur.getIdUsuarioRol() > 0) {
            return new ResponseEntity<>(usuarioRolService.update(usuarioRol), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioRol> delete(@PathVariable("id") Long id) {
        try {
            usuarioRolService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
