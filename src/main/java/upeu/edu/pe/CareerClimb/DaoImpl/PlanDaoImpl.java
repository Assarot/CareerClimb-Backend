package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.PlanDao;
import upeu.edu.pe.CareerClimb.Entity.Plan;
import upeu.edu.pe.CareerClimb.Repository.PlanRepository;

@Component
public class PlanDaoImpl implements PlanDao {
    @Autowired
    private PlanRepository planRepository;

    @Override
    public Plan create(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan update(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public void delete(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public Optional<Plan> getById(Long id) {
        return planRepository.findById(id);
    }

    @Override
    public List<Plan> getAll() {
        return planRepository.findAll();
    }
}
