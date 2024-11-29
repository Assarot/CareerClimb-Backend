package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.PersonaDao;
import upeu.edu.pe.CareerClimb.Entity.Persona;
import upeu.edu.pe.CareerClimb.Service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaDao personaDao;

    @Override
    public Persona create(Persona persona) {
        return personaDao.create(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaDao.update(persona);
    }

    @Override
    public void delete(Long id) {
        personaDao.delete(id);
    }

    @Override
    public Optional<Persona> getById(Long id) {
        return personaDao.getById(id);
    }

    @Override
    public List<Persona> getAll() {
        return personaDao.getAll();
    }
}
