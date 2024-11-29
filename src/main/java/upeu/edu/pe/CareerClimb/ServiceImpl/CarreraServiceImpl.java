package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.CarreraDao;
import upeu.edu.pe.CareerClimb.Entity.Carrera;
import upeu.edu.pe.CareerClimb.Service.CarreraService;

@Service
public class CarreraServiceImpl implements CarreraService {
    @Autowired
    private CarreraDao carreraDao;

    @Override
    public Carrera create(Carrera carrera) {
        return carreraDao.create(carrera);
    }

    @Override
    public Carrera update(Carrera carrera) {
        return carreraDao.update(carrera);
    }

    @Override
    public void delete(Long id) {
        carreraDao.delete(id);
    }

    @Override
    public Optional<Carrera> getById(Long id) {
        return carreraDao.getById(id);
    }

    @Override
    public List<Carrera> getAll() {
        return carreraDao.getAll();
    }
}
