package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.PlanCarreraDao;
import upeu.edu.pe.CareerClimb.Entity.PlanCarrera;
import upeu.edu.pe.CareerClimb.Service.PlanCarreraService;

@Service
public class PlanCarreraServiceImpl implements PlanCarreraService {
    @Autowired
    private PlanCarreraDao plancarreraDao;

    @Override
    public PlanCarrera create(PlanCarrera plancarrera) {
        return plancarreraDao.create(plancarrera);
    }

    @Override
    public PlanCarrera update(PlanCarrera plancarrera) {
        return plancarreraDao.update(plancarrera);
    }

    @Override
    public void delete(Long id) {
        plancarreraDao.delete(id);
    }

    @Override
    public Optional<PlanCarrera> getById(Long id) {
        return plancarreraDao.getById(id);
    }

    @Override
    public List<PlanCarrera> getAll() {
        return plancarreraDao.getAll();
    }
}
