package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Linea;

public interface LineaService {
    Linea create(Linea linea);
    Linea update(Linea linea);
    void delete(Long id);
    Optional<Linea> getById(Long id);
    List<Linea> getAll();
}
