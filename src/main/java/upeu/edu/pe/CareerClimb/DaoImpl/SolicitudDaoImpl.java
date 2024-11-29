package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.SolicitudDao;
import upeu.edu.pe.CareerClimb.Entity.Solicitud;
import upeu.edu.pe.CareerClimb.Repository.SolicitudRepository;

@Component
public class SolicitudDaoImpl implements SolicitudDao {
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public Solicitud create(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud update(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public void delete(Long id) {
        solicitudRepository.deleteById(id);
    }

    @Override
    public Optional<Solicitud> getById(Long id) {
        return solicitudRepository.findById(id);
    }

    @Override
    public List<Solicitud> getAll() {
        return solicitudRepository.findAll();
    }
}
