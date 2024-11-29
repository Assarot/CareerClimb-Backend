package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.DetalleCargoDao;
import upeu.edu.pe.CareerClimb.Entity.DetalleCargo;
import upeu.edu.pe.CareerClimb.Repository.DetalleCargoRepository;

@Component
public class DetalleCargoDaoImpl implements DetalleCargoDao {
    @Autowired
    private DetalleCargoRepository detallecargoRepository;

    @Override
    public DetalleCargo create(DetalleCargo detallecargo) {
        return detallecargoRepository.save(detallecargo);
    }

    @Override
    public DetalleCargo update(DetalleCargo detallecargo) {
        return detallecargoRepository.save(detallecargo);
    }

    @Override
    public void delete(Long id) {
        detallecargoRepository.deleteById(id);
    }

    @Override
    public Optional<DetalleCargo> getById(Long id) {
        return detallecargoRepository.findById(id);
    }

    @Override
    public List<DetalleCargo> getAll() {
        return detallecargoRepository.findAll();
    }
}
