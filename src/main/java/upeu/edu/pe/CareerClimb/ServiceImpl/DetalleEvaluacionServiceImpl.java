package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.DetalleEvaluacionDao;
import upeu.edu.pe.CareerClimb.Entity.DetalleEvaluacion;
import upeu.edu.pe.CareerClimb.Service.DetalleEvaluacionService;

@Service
public class DetalleEvaluacionServiceImpl implements DetalleEvaluacionService {
    @Autowired
    private DetalleEvaluacionDao detalleevaluacionDao;

    @Override
    public DetalleEvaluacion create(DetalleEvaluacion detalleevaluacion) {
        return detalleevaluacionDao.create(detalleevaluacion);
    }

    @Override
    public DetalleEvaluacion update(DetalleEvaluacion detalleevaluacion) {
        return detalleevaluacionDao.update(detalleevaluacion);
    }

    @Override
    public void delete(Long id) {
        detalleevaluacionDao.delete(id);
    }

    @Override
    public Optional<DetalleEvaluacion> getById(Long id) {
        return detalleevaluacionDao.getById(id);
    }

    @Override
    public List<DetalleEvaluacion> getAll() {
        return detalleevaluacionDao.getAll();
    }
}
