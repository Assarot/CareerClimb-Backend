package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.PPP;

public interface PPPDao {
    PPP create(PPP ppp);
    PPP update(PPP ppp);
    void delete(Long id);
    Optional<PPP> getById(Long id);
    List<PPP> getAll();
}
