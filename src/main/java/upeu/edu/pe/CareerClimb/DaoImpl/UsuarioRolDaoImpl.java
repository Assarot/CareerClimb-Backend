package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.UsuarioRolDao;
import upeu.edu.pe.CareerClimb.Entity.UsuarioRol;
import upeu.edu.pe.CareerClimb.Repository.UsuarioRolRepository;

@Component
public class UsuarioRolDaoImpl implements UsuarioRolDao {
    @Autowired
    private UsuarioRolRepository usuariorolRepository;

    @Override
    public UsuarioRol create(UsuarioRol usuariorol) {
        return usuariorolRepository.save(usuariorol);
    }

    @Override
    public UsuarioRol update(UsuarioRol usuariorol) {
        return usuariorolRepository.save(usuariorol);
    }

    @Override
    public void delete(Long id) {
        usuariorolRepository.deleteById(id);
    }

    @Override
    public Optional<UsuarioRol> getById(Long id) {
        return usuariorolRepository.findById(id);
    }

    @Override
    public List<UsuarioRol> getAll() {
        return usuariorolRepository.findAll();
    }
}
