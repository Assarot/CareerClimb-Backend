package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Control;

public interface ControlDao {
    Control create(Control control);
    Control update(Control control);
    void delete(Long id);
    Optional<Control> getById(Long id);
    List<Control> getAll();
}
