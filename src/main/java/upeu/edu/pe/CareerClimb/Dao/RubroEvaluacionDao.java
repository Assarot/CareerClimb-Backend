package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.RubroEvaluacion;

public interface RubroEvaluacionDao {
    RubroEvaluacion create(RubroEvaluacion rubroEvaluacion);
    RubroEvaluacion update(RubroEvaluacion rubroEvaluacion);
    void delete(Long id);
    Optional<RubroEvaluacion> getById(Long id);
    List<RubroEvaluacion> getAll();
}
