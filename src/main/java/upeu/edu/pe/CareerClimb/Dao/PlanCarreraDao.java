package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.PlanCarrera;

public interface PlanCarreraDao {
    PlanCarrera create(PlanCarrera plancarrera);
    PlanCarrera update(PlanCarrera plancarrera);
    void delete(Long id);
    Optional<PlanCarrera> getById(Long id);
    List<PlanCarrera> getAll();
}
