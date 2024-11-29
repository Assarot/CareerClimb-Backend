package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.DetallePPP;

public interface DetallePPPService {
    DetallePPP create(DetallePPP detalleppp);
    DetallePPP update(DetallePPP detalleppp);
    void delete(Long id);
    Optional<DetallePPP> getById(Long id);
    List<DetallePPP> getAll();
}
