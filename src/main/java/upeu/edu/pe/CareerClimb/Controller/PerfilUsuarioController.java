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

import upeu.edu.pe.CareerClimb.Entity.PerfilUsuario;
import upeu.edu.pe.CareerClimb.Service.PerfilUsuarioService;

@RestController
@RequestMapping("/api/perfiles-usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class PerfilUsuarioController {
    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public ResponseEntity<List<PerfilUsuario>> getAll() {
        try {
            List<PerfilUsuario> p = perfilUsuarioService.getAll();
            if (p.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuario> getById(@PathVariable("id") Long id) {
        try {
            PerfilUsuario p = perfilUsuarioService.getById(id).get();
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<PerfilUsuario> create(@Validated @RequestBody PerfilUsuario perfilUsuario) {
        try {
            PerfilUsuario p = perfilUsuarioService.create(perfilUsuario);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody PerfilUsuario perfilUsuario) {
        PerfilUsuario p = perfilUsuarioService.getById(id).get();
        if (p.getIdPerfilUsuario() > 0) {
            return new ResponseEntity<>(perfilUsuarioService.update(perfilUsuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PerfilUsuario> delete(@PathVariable("id") Long id) {
        try {
            perfilUsuarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
