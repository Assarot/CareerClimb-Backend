package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.DetalleEvaluacion;

public interface DetalleEvaluacionDao {
    DetalleEvaluacion create(DetalleEvaluacion detalleevaluacion);
    DetalleEvaluacion update(DetalleEvaluacion detalleevaluacion);
    void delete(Long id);
    Optional<DetalleEvaluacion> getById(Long id);
    List<DetalleEvaluacion> getAll();
}
