package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Cargo;

public interface CargoService {
    Cargo create(Cargo cargo);
    Cargo update(Cargo cargo);
    void delete(Long id);
    Optional<Cargo> getById(Long id);
    List<Cargo> getAll();
}
