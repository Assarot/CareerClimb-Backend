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

import upeu.edu.pe.CareerClimb.Entity.PersonaDetalleCargo;
import upeu.edu.pe.CareerClimb.Service.PersonaDetalleCargoService;

@RestController
@RequestMapping("/api/persona-detalle-cargo")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaDetalleCargoController {
    @Autowired
    private PersonaDetalleCargoService personaDetalleCargoService;

    @GetMapping
    public ResponseEntity<List<PersonaDetalleCargo>> getAll() {
        try {
            List<PersonaDetalleCargo> p = personaDetalleCargoService.getAll();
            if (p.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDetalleCargo> getById(@PathVariable("id") Long id) {
        try {
            PersonaDetalleCargo p = personaDetalleCargoService.getById(id).get();
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<PersonaDetalleCargo> create(@Validated @RequestBody PersonaDetalleCargo personaDetalleCargo) {
        try {
            PersonaDetalleCargo p = personaDetalleCargoService.create(personaDetalleCargo);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody PersonaDetalleCargo personaDetalleCargo) {
        PersonaDetalleCargo p = personaDetalleCargoService.getById(id).get();
        if (p.getIdPersonaDetalleCargo() > 0) {
            return new ResponseEntity<>(personaDetalleCargoService.update(personaDetalleCargo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaDetalleCargo> delete(@PathVariable("id") Long id) {
        try {
            personaDetalleCargoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
