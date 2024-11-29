package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.UsuarioRol;

public interface UsuarioRolDao {
    UsuarioRol create(UsuarioRol usuariorol);
    UsuarioRol update(UsuarioRol usuariorol);
    void delete(Long id);
    Optional<UsuarioRol> getById(Long id);
    List<UsuarioRol> getAll();
}
