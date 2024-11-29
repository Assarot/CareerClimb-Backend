package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Carrera;

public interface CarreraDao {
    Carrera create(Carrera carrera);
    Carrera update(Carrera carrera);
    void delete(Long id);
    Optional<Carrera> getById(Long id);
    List<Carrera> getAll();
}
