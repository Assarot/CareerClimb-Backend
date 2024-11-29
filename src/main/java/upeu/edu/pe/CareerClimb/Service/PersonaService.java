package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Persona;

public interface PersonaService {
    Persona create(Persona persona);
    Persona update(Persona persona);
    void delete(Long id);
    Optional<Persona> getById(Long id);
    List<Persona> getAll();
}
