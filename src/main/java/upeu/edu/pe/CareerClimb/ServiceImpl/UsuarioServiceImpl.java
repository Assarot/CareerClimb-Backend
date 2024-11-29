package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.UsuarioDao;
import upeu.edu.pe.CareerClimb.Entity.Usuario;
import upeu.edu.pe.CareerClimb.Service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioDao.create(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioDao.update(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioDao.delete(id);
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        return usuarioDao.getById(id);
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioDao.getAll();
    }

	@Override
	public String obtenerNombreUsuario(Long idPersona) {
		return usuarioDao.obtenerNombreUsuario(idPersona);
	}
}
