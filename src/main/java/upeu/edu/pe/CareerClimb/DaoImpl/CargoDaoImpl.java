package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.CargoDao;
import upeu.edu.pe.CareerClimb.Entity.Cargo;
import upeu.edu.pe.CareerClimb.Repository.CargoRepository;

@Component
public class CargoDaoImpl implements CargoDao {
    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Cargo create(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public Cargo update(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public void delete(Long id) {
        cargoRepository.deleteById(id);
    }

    @Override
    public Optional<Cargo> getById(Long id) {
        return cargoRepository.findById(id);
    }

    @Override
    public List<Cargo> getAll() {
        return cargoRepository.findAll();
    }
}
