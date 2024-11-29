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

import upeu.edu.pe.CareerClimb.Entity.DetalleCargo;
import upeu.edu.pe.CareerClimb.Service.DetalleCargoService;

@RestController
@RequestMapping("/api/detalle-cargos")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleCargoController {
    @Autowired
    private DetalleCargoService detalleCargoService;

    @GetMapping
    public ResponseEntity<List<DetalleCargo>> getAll() {
        try {
            List<DetalleCargo> d = detalleCargoService.getAll();
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
    public ResponseEntity<DetalleCargo> getById(@PathVariable("id") Long id) {
        try {
            DetalleCargo d = detalleCargoService.getById(id).get();
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<DetalleCargo> create(@Validated @RequestBody DetalleCargo detalleCargo) {
        try {
            DetalleCargo d = detalleCargoService.create(detalleCargo);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody DetalleCargo detalleCargo) {
        DetalleCargo d = detalleCargoService.getById(id).get();
        if (d.getIdDetalleCargo() > 0) {
            return new ResponseEntity<>(detalleCargoService.update(detalleCargo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetalleCargo> delete(@PathVariable("id") Long id) {
        try {
            detalleCargoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
