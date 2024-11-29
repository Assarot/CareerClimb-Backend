package upeu.edu.pe.CareerClimb.Service;


import java.util.List;
import java.util.Optional;

import upeu.edu.pe.CareerClimb.Entity.Rol;

public interface RolService {
    Rol create(Rol rol);
    Rol update(Rol rol);
    void delete(Long id);
    Optional<Rol> getById(Long id);
    List<Rol> getAll();
}
