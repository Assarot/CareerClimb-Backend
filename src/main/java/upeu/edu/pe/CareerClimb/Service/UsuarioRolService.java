package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.UsuarioRol;

public interface UsuarioRolService {
    UsuarioRol create(UsuarioRol usuariorol);
    UsuarioRol update(UsuarioRol usuariorol);
    void delete(Long id);
    Optional<UsuarioRol> getById(Long id);
    List<UsuarioRol> getAll();
}
