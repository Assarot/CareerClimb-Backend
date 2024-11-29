package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Requerimiento;

public interface RequerimientoService {
    Requerimiento create(Requerimiento requerimiento);
    Requerimiento update(Requerimiento requerimiento);
    void delete(Long id);
    Optional<Requerimiento> getById(Long id);
    List<Requerimiento> getAll();
}
