package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.InformePPP;

public interface InformePPPService {
    InformePPP create(InformePPP informeppp);
    InformePPP update(InformePPP informeppp);
    void delete(Long id);
    Optional<InformePPP> getById(Long id);
    List<InformePPP> getAll();
}
