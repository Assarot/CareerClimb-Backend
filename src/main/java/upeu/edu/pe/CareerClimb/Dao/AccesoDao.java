package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Acceso;

public interface AccesoDao {
    Acceso create(Acceso acceso);
    Acceso update(Acceso acceso);
    void delete(Long id);
    Optional<Acceso> getById(Long id);
    List<Acceso> getAll();
    List<Acceso> findAccesosByRol(String rol);
    
}
