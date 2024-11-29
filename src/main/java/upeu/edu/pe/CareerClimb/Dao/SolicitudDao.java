package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Solicitud;

public interface SolicitudDao {
    Solicitud create(Solicitud solicitud);
    Solicitud update(Solicitud solicitud);
    void delete(Long id);
    Optional<Solicitud> getById(Long id);
    List<Solicitud> getAll();
}
