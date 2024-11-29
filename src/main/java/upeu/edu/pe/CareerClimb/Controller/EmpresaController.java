package upeu.edu.pe.CareerClimb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import upeu.edu.pe.CareerClimb.Entity.Empresa;
import upeu.edu.pe.CareerClimb.Service.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> getAll() {
        try {
            List<Empresa> e = empresaService.getAll();
            if (e.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(e, HttpStatus.OK);
        } catch (Exception ex) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable("id") Long id) {
        try {
            Empresa e = empresaService.getById(id).get();
            return new ResponseEntity<>(e, HttpStatus.OK);
        } catch (Exception ex) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@Validated @RequestBody Empresa empresa) {
        try {
            Empresa e = empresaService.create(empresa);
            return new ResponseEntity<>(e, HttpStatus.CREATED);
        } catch (Exception ex) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody Empresa empresa) {
        Empresa e = empresaService.getById(id).get();
        if (e.getIdEmpresa() > 0) {
            return new ResponseEntity<>(empresaService.update(empresa), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> delete(@PathVariable("id") Long id) {
        try {
            empresaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/deleteByRuc/{empresaRuc}")
    public ResponseEntity<Void> deleteByRuc(@PathVariable("empresaRuc") String empresaRuc) {
        try {
            empresaService.deleteEmpresa(empresaRuc);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException ex) {
            if (ex.getMessage().contains("Empresa con el RUC especificado no encontrada")) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
