package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.PersonaDetalleCargo;

public interface PersonaDetalleCargoDao {
    PersonaDetalleCargo create(PersonaDetalleCargo personadetallecargo);
    PersonaDetalleCargo update(PersonaDetalleCargo personadetallecargo);
    void delete(Long id);
    Optional<PersonaDetalleCargo> getById(Long id);
    List<PersonaDetalleCargo> getAll();
}
