package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.DetalleDoc;

public interface DetalleDocService {
    DetalleDoc create(DetalleDoc detalledoc);
    DetalleDoc update(DetalleDoc detalledoc);
    void delete(Long id);
    Optional<DetalleDoc> getById(Long id);
    List<DetalleDoc> getAll();
}
