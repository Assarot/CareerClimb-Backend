package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.EvaluacionDao;
import upeu.edu.pe.CareerClimb.Entity.Evaluacion;
import upeu.edu.pe.CareerClimb.Repository.EvaluacionRepository;

@Component
public class EvaluacionDaoImpl implements EvaluacionDao {
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Override
    public Evaluacion create(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public Evaluacion update(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public void delete(Long id) {
        evaluacionRepository.deleteById(id);
    }

    @Override
    public Optional<Evaluacion> getById(Long id) {
        return evaluacionRepository.findById(id);
    }

    @Override
    public List<Evaluacion> getAll() {
        return evaluacionRepository.findAll();
    }
}
