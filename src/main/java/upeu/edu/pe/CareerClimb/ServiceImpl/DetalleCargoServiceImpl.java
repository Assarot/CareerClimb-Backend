package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.DetalleCargoDao;
import upeu.edu.pe.CareerClimb.Entity.DetalleCargo;
import upeu.edu.pe.CareerClimb.Service.DetalleCargoService;

@Service
public class DetalleCargoServiceImpl implements DetalleCargoService {
    @Autowired
    private DetalleCargoDao detallecargoDao;

    @Override
    public DetalleCargo create(DetalleCargo detallecargo) {
        return detallecargoDao.create(detallecargo);
    }

    @Override
    public DetalleCargo update(DetalleCargo detallecargo) {
        return detallecargoDao.update(detallecargo);
    }

    @Override
    public void delete(Long id) {
        detallecargoDao.delete(id);
    }

    @Override
    public Optional<DetalleCargo> getById(Long id) {
        return detallecargoDao.getById(id);
    }

    @Override
    public List<DetalleCargo> getAll() {
        return detallecargoDao.getAll();
    }
}
