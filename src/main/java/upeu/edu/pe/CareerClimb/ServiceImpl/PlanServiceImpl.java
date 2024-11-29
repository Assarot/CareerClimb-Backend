package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.PlanDao;
import upeu.edu.pe.CareerClimb.Entity.Plan;
import upeu.edu.pe.CareerClimb.Service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanDao planDao;

    @Override
    public Plan create(Plan plan) {
        return planDao.create(plan);
    }

    @Override
    public Plan update(Plan plan) {
        return planDao.update(plan);
    }

    @Override
    public void delete(Long id) {
        planDao.delete(id);
    }

    @Override
    public Optional<Plan> getById(Long id) {
        return planDao.getById(id);
    }

    @Override
    public List<Plan> getAll() {
        return planDao.getAll();
    }
}
