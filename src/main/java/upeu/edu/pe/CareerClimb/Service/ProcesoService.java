package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Proceso;

public interface ProcesoService {
    Proceso create(Proceso proceso);
    Proceso update(Proceso proceso);
    void delete(Long id);
    Optional<Proceso> getById(Long id);
    List<Proceso> getAll();
}
