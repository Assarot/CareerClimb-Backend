package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Linea;

public interface LineaDao {
    Linea create(Linea linea);
    Linea update(Linea linea);
    void delete(Long id);
    Optional<Linea> getById(Long id);
    List<Linea> getAll();
}
