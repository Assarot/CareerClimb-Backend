package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.PerfilUsuario;

public interface PerfilUsuarioService {
    PerfilUsuario create(PerfilUsuario perfilusuario);
    PerfilUsuario update(PerfilUsuario perfilusuario);
    void delete(Long id);
    Optional<PerfilUsuario> getById(Long id);
    List<PerfilUsuario> getAll();
}
