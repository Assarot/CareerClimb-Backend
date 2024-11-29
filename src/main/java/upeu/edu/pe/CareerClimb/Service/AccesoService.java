package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Acceso;

public interface AccesoService {
    Acceso create(Acceso acceso);
    Acceso update(Acceso acceso);
    void delete(Long id);
    Optional<Acceso> getById(Long id);
    List<Acceso> getAll();
    List<Acceso> findAccesosByRol(String rol);
    List<Acceso> organizarJerarquiaAccesos(List<Acceso> accesos);
}
