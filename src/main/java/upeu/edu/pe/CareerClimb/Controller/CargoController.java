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
import upeu.edu.pe.CareerClimb.Entity.Cargo;
import upeu.edu.pe.CareerClimb.Service.CargoService;

@RestController
@RequestMapping("/api/cargos")
@CrossOrigin(origins = "http://localhost:4200")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<Cargo>> getAll() {
    	try {
    		List<Cargo> c = cargoService.getAll();
    		if (c.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
    		return new ResponseEntity<>(c, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getById(@PathVariable("id") Long id) {
    	 try {
             Cargo c = cargoService.getById(id).get();
             return new ResponseEntity<>(c, HttpStatus.OK);
         } catch (Exception e) {
             // TODO: handle exception
             return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    @PostMapping
    public ResponseEntity<Cargo> create(@Validated @RequestBody Cargo cargo) {
        try {
			Cargo c = cargoService.create(cargo);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody Cargo cargo) {
        Cargo c = cargoService.getById(id).get();
        if (c.getIdCargo()>0) {
			return new ResponseEntity<>(cargoService.update(cargo), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cargo> delete(@PathVariable("id") Long id) {
        try {
			cargoService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}