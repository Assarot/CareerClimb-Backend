package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Solicitud;

public interface SolicitudService {
    Solicitud create(Solicitud solicitud);
    Solicitud update(Solicitud solicitud);
    void delete(Long id);
    Optional<Solicitud> getById(Long id);
    List<Solicitud> getAll();
}
