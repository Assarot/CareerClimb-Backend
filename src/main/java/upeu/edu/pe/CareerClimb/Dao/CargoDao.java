package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Cargo;

public interface CargoDao {
    Cargo create(Cargo cargo);
    Cargo update(Cargo cargo);
    void delete(Long id);
    Optional<Cargo> getById(Long id);
    List<Cargo> getAll();
}
