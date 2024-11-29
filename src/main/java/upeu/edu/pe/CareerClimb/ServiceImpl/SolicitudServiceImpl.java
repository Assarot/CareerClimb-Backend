package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.SolicitudDao;
import upeu.edu.pe.CareerClimb.Entity.Solicitud;
import upeu.edu.pe.CareerClimb.Service.SolicitudService;

@Service
public class SolicitudServiceImpl implements SolicitudService {
    @Autowired
    private SolicitudDao solicitudDao;

    @Override
    public Solicitud create(Solicitud solicitud) {
        return solicitudDao.create(solicitud);
    }

    @Override
    public Solicitud update(Solicitud solicitud) {
        return solicitudDao.update(solicitud);
    }

    @Override
    public void delete(Long id) {
        solicitudDao.delete(id);
    }

    @Override
    public Optional<Solicitud> getById(Long id) {
        return solicitudDao.getById(id);
    }

    @Override
    public List<Solicitud> getAll() {
        return solicitudDao.getAll();
    }
}
