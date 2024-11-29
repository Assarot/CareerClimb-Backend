package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.DetalleCargo;

public interface DetalleCargoService {
    DetalleCargo create(DetalleCargo detallecargo);
    DetalleCargo update(DetalleCargo detallecargo);
    void delete(Long id);
    Optional<DetalleCargo> getById(Long id);
    List<DetalleCargo> getAll();
}
