package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.PersonaDetalleCargoDao;
import upeu.edu.pe.CareerClimb.Entity.PersonaDetalleCargo;
import upeu.edu.pe.CareerClimb.Service.PersonaDetalleCargoService;

@Service
public class PersonaDetalleCargoServiceImpl implements PersonaDetalleCargoService {
    @Autowired
    private PersonaDetalleCargoDao personadetallecargoDao;

    @Override
    public PersonaDetalleCargo create(PersonaDetalleCargo personadetallecargo) {
        return personadetallecargoDao.create(personadetallecargo);
    }

    @Override
    public PersonaDetalleCargo update(PersonaDetalleCargo personadetallecargo) {
        return personadetallecargoDao.update(personadetallecargo);
    }

    @Override
    public void delete(Long id) {
        personadetallecargoDao.delete(id);
    }

    @Override
    public Optional<PersonaDetalleCargo> getById(Long id) {
        return personadetallecargoDao.getById(id);
    }

    @Override
    public List<PersonaDetalleCargo> getAll() {
        return personadetallecargoDao.getAll();
    }
}
