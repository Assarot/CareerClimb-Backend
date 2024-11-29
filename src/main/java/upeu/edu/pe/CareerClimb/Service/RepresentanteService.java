package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Representante;

public interface RepresentanteService {
    Representante create(Representante representante);
    Representante update(Representante representante);
    void delete(Long id);
    Optional<Representante> getById(Long id);
    List<Representante> getAll();
}
