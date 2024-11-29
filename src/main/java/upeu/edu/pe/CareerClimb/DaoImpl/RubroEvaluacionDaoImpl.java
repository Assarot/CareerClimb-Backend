package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.RubroEvaluacionDao;
import upeu.edu.pe.CareerClimb.Entity.RubroEvaluacion;
import upeu.edu.pe.CareerClimb.Repository.RubroEvaluacionRepository;

@Component
public class RubroEvaluacionDaoImpl implements RubroEvaluacionDao {

    @Autowired
    private RubroEvaluacionRepository rubroEvaluacionRepository;

    @Override
    public RubroEvaluacion create(RubroEvaluacion rubroEvaluacion) {
        return rubroEvaluacionRepository.save(rubroEvaluacion);
    }

    @Override
    public RubroEvaluacion update(RubroEvaluacion rubroEvaluacion) {
        return rubroEvaluacionRepository.save(rubroEvaluacion);
    }

    @Override
    public void delete(Long id) {
        rubroEvaluacionRepository.deleteById(id);
    }

    @Override
    public Optional<RubroEvaluacion> getById(Long id) {
        return rubroEvaluacionRepository.findById(id);
    }

    @Override
    public List<RubroEvaluacion> getAll() {
        return rubroEvaluacionRepository.findAll();
    }
}
