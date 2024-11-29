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

import upeu.edu.pe.CareerClimb.Entity.InformePPP;
import upeu.edu.pe.CareerClimb.Service.InformePPPService;

@RestController
@RequestMapping("/api/informes-ppp")
@CrossOrigin(origins = "http://localhost:4200")
public class InformePPPController {
    @Autowired
    private InformePPPService informePPPService;

    @GetMapping
    public ResponseEntity<List<InformePPP>> getAll() {
        try {
            List<InformePPP> i = informePPPService.getAll();
            if (i.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(i, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformePPP> getById(@PathVariable("id") Long id) {
        try {
            InformePPP i = informePPPService.getById(id).get();
            return new ResponseEntity<>(i, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<InformePPP> create(@Validated @RequestBody InformePPP informePPP) {
        try {
            InformePPP i = informePPPService.create(informePPP);
            return new ResponseEntity<>(i, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody InformePPP informePPP) {
        InformePPP i = informePPPService.getById(id).get();
        if (i.getIdInformePPP() > 0) {
            return new ResponseEntity<>(informePPPService.update(informePPP), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InformePPP> delete(@PathVariable("id") Long id) {
        try {
            informePPPService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
