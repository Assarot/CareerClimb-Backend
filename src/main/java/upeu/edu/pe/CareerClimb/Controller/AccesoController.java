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

import upeu.edu.pe.CareerClimb.Entity.Acceso;
import upeu.edu.pe.CareerClimb.Service.AccesoService;

@RestController
@RequestMapping("/api/accesos")
@CrossOrigin(origins = "http://localhost:4200")
public class AccesoController {
    @Autowired
    private AccesoService accesoService;

    @GetMapping
    public ResponseEntity<List<Acceso>> getAll() {
        try {
			List<Acceso> a = accesoService.getAll();
			if (a.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(a, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acceso> getById(@PathVariable("id") Long id) {
        try {
			Acceso a = accesoService.getById(id).get();
			return new ResponseEntity<>(a, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PostMapping
    public ResponseEntity<Acceso> create(@Validated @RequestBody Acceso acceso) {
    	try {
			Acceso a = accesoService.create(acceso);
			return new ResponseEntity<>(a, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody Acceso acceso) {
        try {
            // Verificar si el acceso con el ID proporcionado existe
            Acceso accesoExistente = accesoService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Acceso no encontrado con ID: " + id));

            // Actualizar los campos del acceso existente con los nuevos valores
            accesoExistente.setTitulo(acceso.getTitulo());
            accesoExistente.setUrl(acceso.getUrl());
            accesoExistente.setIcono(acceso.getIcono());
            accesoExistente.setIsActive(acceso.getIsActive());
            accesoExistente.setAccesoPadre(acceso.getAccesoPadre());

            // Guardar los cambios
            Acceso accesoActualizado = accesoService.update(accesoExistente);

            return new ResponseEntity<>(accesoActualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Acceso> delete(@PathVariable("id") Long id) {
        try {
        	accesoService.delete(id);
        	return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<Acceso>> obtenerAccesosPorRol(@PathVariable String rol) {
        try {
            // Llamar a la query nativa definida en el repositorio
            List<Acceso> accesos = accesoService.findAccesosByRol(rol);
            if (accesos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
            return ResponseEntity.ok(accesos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
