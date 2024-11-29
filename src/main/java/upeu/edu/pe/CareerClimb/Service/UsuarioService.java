package upeu.edu.pe.CareerClimb.Service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Usuario;

public interface UsuarioService {
    Usuario create(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(Long id);
    Optional<Usuario> getById(Long id);
    List<Usuario> getAll();
    String obtenerNombreUsuario(Long idPersona);
}
