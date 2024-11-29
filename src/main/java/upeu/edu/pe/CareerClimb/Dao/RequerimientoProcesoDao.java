package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.RequerimientoProceso;

public interface RequerimientoProcesoDao {
    RequerimientoProceso create(RequerimientoProceso requerimientoproceso);
    RequerimientoProceso update(RequerimientoProceso requerimientoproceso);
    void delete(Long id);
    Optional<RequerimientoProceso> getById(Long id);
    List<RequerimientoProceso> getAll();
}
