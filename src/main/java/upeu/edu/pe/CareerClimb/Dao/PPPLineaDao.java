package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.PPPLinea;

public interface PPPLineaDao {
    PPPLinea create(PPPLinea ppplinea);
    PPPLinea update(PPPLinea ppplinea);
    void delete(Long id);
    Optional<PPPLinea> getById(Long id);
    List<PPPLinea> getAll();
}
