package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.PersonaDetalleCargoDao;
import upeu.edu.pe.CareerClimb.Entity.PersonaDetalleCargo;
import upeu.edu.pe.CareerClimb.Repository.PersonaDetalleCargoRepository;

@Component
public class PersonaDetalleCargoDaoImpl implements PersonaDetalleCargoDao {
    @Autowired
    private PersonaDetalleCargoRepository personadetallecargoRepository;

    @Override
    public PersonaDetalleCargo create(PersonaDetalleCargo personadetallecargo) {
        return personadetallecargoRepository.save(personadetallecargo);
    }

    @Override
    public PersonaDetalleCargo update(PersonaDetalleCargo personadetallecargo) {
        return personadetallecargoRepository.save(personadetallecargo);
    }

    @Override
    public void delete(Long id) {
        personadetallecargoRepository.deleteById(id);
    }

    @Override
    public Optional<PersonaDetalleCargo> getById(Long id) {
        return personadetallecargoRepository.findById(id);
    }

    @Override
    public List<PersonaDetalleCargo> getAll() {
        return personadetallecargoRepository.findAll();
    }
}
