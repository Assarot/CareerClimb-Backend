package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.PlanCarreraDao;
import upeu.edu.pe.CareerClimb.Entity.PlanCarrera;
import upeu.edu.pe.CareerClimb.Repository.PlanCarreraRepository;

@Component
public class PlanCarreraDaoImpl implements PlanCarreraDao {
    @Autowired
    private PlanCarreraRepository plancarreraRepository;

    @Override
    public PlanCarrera create(PlanCarrera plancarrera) {
        return plancarreraRepository.save(plancarrera);
    }

    @Override
    public PlanCarrera update(PlanCarrera plancarrera) {
        return plancarreraRepository.save(plancarrera);
    }

    @Override
    public void delete(Long id) {
        plancarreraRepository.deleteById(id);
    }

    @Override
    public Optional<PlanCarrera> getById(Long id) {
        return plancarreraRepository.findById(id);
    }

    @Override
    public List<PlanCarrera> getAll() {
        return plancarreraRepository.findAll();
    }
}
