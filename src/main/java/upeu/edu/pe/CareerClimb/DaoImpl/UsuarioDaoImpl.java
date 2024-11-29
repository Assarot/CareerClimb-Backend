package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.UsuarioDao;
import upeu.edu.pe.CareerClimb.Entity.Usuario;
import upeu.edu.pe.CareerClimb.Repository.UsuarioRepository;

@Component
public class UsuarioDaoImpl implements UsuarioDao {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

	@Override
	public String obtenerNombreUsuario(Long idPersona) {
		return usuarioRepository.generarNombreUsuario(idPersona);
	}
}
