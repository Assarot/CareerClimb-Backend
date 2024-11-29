package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Proceso;

public interface ProcesoDao {
    Proceso create(Proceso proceso);
    Proceso update(Proceso proceso);
    void delete(Long id);
    Optional<Proceso> getById(Long id);
    List<Proceso> getAll();
}
