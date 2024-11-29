package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;

import upeu.edu.pe.CareerClimb.Entity.Acceso;
import upeu.edu.pe.CareerClimb.Entity.Rol;

public interface RolDao {
    Rol create(Rol rol);
    Rol update(Rol rol);
    void delete(Long id);
    Optional<Rol> getById(Long id);
    List<Rol> getAll();
}
