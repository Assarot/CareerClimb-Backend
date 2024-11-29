package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.CarreraDao;
import upeu.edu.pe.CareerClimb.Entity.Carrera;
import upeu.edu.pe.CareerClimb.Repository.CarreraRepository;

@Component
public class CarreraDaoImpl implements CarreraDao {
    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public Carrera create(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public Carrera update(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public void delete(Long id) {
        carreraRepository.deleteById(id);
    }

    @Override
    public Optional<Carrera> getById(Long id) {
        return carreraRepository.findById(id);
    }

    @Override
    public List<Carrera> getAll() {
        return carreraRepository.findAll();
    }
}
