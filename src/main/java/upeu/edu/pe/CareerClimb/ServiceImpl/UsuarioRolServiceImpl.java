package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.UsuarioRolDao;
import upeu.edu.pe.CareerClimb.Entity.UsuarioRol;
import upeu.edu.pe.CareerClimb.Service.UsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {
    @Autowired
    private UsuarioRolDao usuariorolDao;

    @Override
    public UsuarioRol create(UsuarioRol usuariorol) {
        return usuariorolDao.create(usuariorol);
    }

    @Override
    public UsuarioRol update(UsuarioRol usuariorol) {
        return usuariorolDao.update(usuariorol);
    }

    @Override
    public void delete(Long id) {
        usuariorolDao.delete(id);
    }

    @Override
    public Optional<UsuarioRol> getById(Long id) {
        return usuariorolDao.getById(id);
    }

    @Override
    public List<UsuarioRol> getAll() {
        return usuariorolDao.getAll();
    }
}
