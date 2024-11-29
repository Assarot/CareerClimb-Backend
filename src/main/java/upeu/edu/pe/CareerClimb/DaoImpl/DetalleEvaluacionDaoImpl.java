package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.DetalleEvaluacionDao;
import upeu.edu.pe.CareerClimb.Entity.DetalleEvaluacion;
import upeu.edu.pe.CareerClimb.Repository.DetalleEvaluacionRepository;

@Component
public class DetalleEvaluacionDaoImpl implements DetalleEvaluacionDao {
    @Autowired
    private DetalleEvaluacionRepository detalleevaluacionRepository;

    @Override
    public DetalleEvaluacion create(DetalleEvaluacion detalleevaluacion) {
        return detalleevaluacionRepository.save(detalleevaluacion);
    }

    @Override
    public DetalleEvaluacion update(DetalleEvaluacion detalleevaluacion) {
        return detalleevaluacionRepository.save(detalleevaluacion);
    }

    @Override
    public void delete(Long id) {
        detalleevaluacionRepository.deleteById(id);
    }

    @Override
    public Optional<DetalleEvaluacion> getById(Long id) {
        return detalleevaluacionRepository.findById(id);
    }

    @Override
    public List<DetalleEvaluacion> getAll() {
        return detalleevaluacionRepository.findAll();
    }
}
