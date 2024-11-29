package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.AccesoRol;

public interface AccesoRolDao {
    AccesoRol create(AccesoRol accesorol);
    AccesoRol update(AccesoRol accesorol);
    void delete(Long id);
    Optional<AccesoRol> getById(Long id);
    List<AccesoRol> getAll();
}
