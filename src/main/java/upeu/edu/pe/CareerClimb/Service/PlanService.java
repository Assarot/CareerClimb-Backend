package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Plan;

public interface PlanService {
    Plan create(Plan plan);
    Plan update(Plan plan);
    void delete(Long id);
    Optional<Plan> getById(Long id);
    List<Plan> getAll();
}
