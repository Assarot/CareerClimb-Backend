package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.RubroEvaluacionDao;
import upeu.edu.pe.CareerClimb.Entity.RubroEvaluacion;
import upeu.edu.pe.CareerClimb.Service.RubroEvaluacionService;

@Service
public class RubroEvaluacionServiceImpl implements RubroEvaluacionService {

    @Autowired
    private RubroEvaluacionDao rubroEvaluacionDao;

    @Override
    public RubroEvaluacion create(RubroEvaluacion rubroEvaluacion) {
        return rubroEvaluacionDao.create(rubroEvaluacion);
    }

    @Override
    public RubroEvaluacion update(RubroEvaluacion rubroEvaluacion) {
        return rubroEvaluacionDao.update(rubroEvaluacion);
    }

    @Override
    public void delete(Long id) {
        rubroEvaluacionDao.delete(id);
    }

    @Override
    public Optional<RubroEvaluacion> getById(Long id) {
        return rubroEvaluacionDao.getById(id);
    }

    @Override
    public List<RubroEvaluacion> getAll() {
        return rubroEvaluacionDao.getAll();
    }
}
