package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.DetallePPP;

public interface DetallePPPDao {
    DetallePPP create(DetallePPP detalleppp);
    DetallePPP update(DetallePPP detalleppp);
    void delete(Long id);
    Optional<DetallePPP> getById(Long id);
    List<DetallePPP> getAll();
}
