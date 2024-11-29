package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.EvaluacionDao;
import upeu.edu.pe.CareerClimb.Entity.Evaluacion;
import upeu.edu.pe.CareerClimb.Service.EvaluacionService;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {
    @Autowired
    private EvaluacionDao evaluacionDao;

    @Override
    public Evaluacion create(Evaluacion evaluacion) {
        return evaluacionDao.create(evaluacion);
    }

    @Override
    public Evaluacion update(Evaluacion evaluacion) {
        return evaluacionDao.update(evaluacion);
    }

    @Override
    public void delete(Long id) {
        evaluacionDao.delete(id);
    }

    @Override
    public Optional<Evaluacion> getById(Long id) {
        return evaluacionDao.getById(id);
    }

    @Override
    public List<Evaluacion> getAll() {
        return evaluacionDao.getAll();
    }
}
