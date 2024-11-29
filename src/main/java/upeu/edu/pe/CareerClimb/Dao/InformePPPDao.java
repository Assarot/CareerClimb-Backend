package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.InformePPP;

public interface InformePPPDao {
    InformePPP create(InformePPP informeppp);
    InformePPP update(InformePPP informeppp);
    void delete(Long id);
    Optional<InformePPP> getById(Long id);
    List<InformePPP> getAll();
}
