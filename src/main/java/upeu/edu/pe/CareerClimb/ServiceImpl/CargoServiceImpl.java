package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.CargoDao;
import upeu.edu.pe.CareerClimb.Entity.Cargo;
import upeu.edu.pe.CareerClimb.Service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoDao cargoDao;

    @Override
    public Cargo create(Cargo cargo) {
        return cargoDao.create(cargo);
    }

    @Override
    public Cargo update(Cargo cargo) {
        return cargoDao.update(cargo);
    }

    @Override
    public void delete(Long id) {
        cargoDao.delete(id);
    }

    @Override
    public Optional<Cargo> getById(Long id) {
        return cargoDao.getById(id);
    }

    @Override
    public List<Cargo> getAll() {
        return cargoDao.getAll();
    }
}
