package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.PersonaDao;
import upeu.edu.pe.CareerClimb.Entity.Persona;
import upeu.edu.pe.CareerClimb.Repository.PersonaRepository;

@Component
public class PersonaDaoImpl implements PersonaDao {
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona create(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Optional<Persona> getById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }
}
