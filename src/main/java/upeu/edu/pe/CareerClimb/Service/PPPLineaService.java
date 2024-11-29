package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.PPPLinea;

public interface PPPLineaService {
    PPPLinea create(PPPLinea ppplinea);
    PPPLinea update(PPPLinea ppplinea);
    void delete(Long id);
    Optional<PPPLinea> getById(Long id);
    List<PPPLinea> getAll();
}
