package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Evaluacion;

public interface EvaluacionDao {
    Evaluacion create(Evaluacion evaluacion);
    Evaluacion update(Evaluacion evaluacion);
    void delete(Long id);
    Optional<Evaluacion> getById(Long id);
    List<Evaluacion> getAll();
}
