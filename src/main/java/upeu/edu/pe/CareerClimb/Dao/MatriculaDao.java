package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Matricula;

public interface MatriculaDao {
    Matricula create(Matricula matricula);
    Matricula update(Matricula matricula);
    void delete(Long id);
    Optional<Matricula> getById(Long id);
    List<Matricula> getAll();
}
