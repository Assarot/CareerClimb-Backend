package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.DetalleEvaluacion;

public interface DetalleEvaluacionService {
    DetalleEvaluacion create(DetalleEvaluacion detalleevaluacion);
    DetalleEvaluacion update(DetalleEvaluacion detalleevaluacion);
    void delete(Long id);
    Optional<DetalleEvaluacion> getById(Long id);
    List<DetalleEvaluacion> getAll();
}
