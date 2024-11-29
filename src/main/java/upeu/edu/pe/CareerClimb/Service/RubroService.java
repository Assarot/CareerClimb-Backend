package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Rubro;

public interface RubroService {
    Rubro create(Rubro rubro);
    Rubro update(Rubro rubro);
    void delete(Long id);
    Optional<Rubro> getById(Long id);
    List<Rubro> getAll();
}
