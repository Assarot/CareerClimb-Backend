package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.DetalleDoc;

public interface DetalleDocDao {
    DetalleDoc create(DetalleDoc detalledoc);
    DetalleDoc update(DetalleDoc detalledoc);
    void delete(Long id);
    Optional<DetalleDoc> getById(Long id);
    List<DetalleDoc> getAll();
}
