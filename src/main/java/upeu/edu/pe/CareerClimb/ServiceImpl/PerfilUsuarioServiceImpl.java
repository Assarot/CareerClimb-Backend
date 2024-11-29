package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.PerfilUsuarioDao;
import upeu.edu.pe.CareerClimb.Entity.PerfilUsuario;
import upeu.edu.pe.CareerClimb.Service.PerfilUsuarioService;

@Service
public class PerfilUsuarioServiceImpl implements PerfilUsuarioService {
    @Autowired
    private PerfilUsuarioDao perfilusuarioDao;

    @Override
    public PerfilUsuario create(PerfilUsuario perfilusuario) {
        return perfilusuarioDao.create(perfilusuario);
    }

    @Override
    public PerfilUsuario update(PerfilUsuario perfilusuario) {
        return perfilusuarioDao.update(perfilusuario);
    }

    @Override
    public void delete(Long id) {
        perfilusuarioDao.delete(id);
    }

    @Override
    public Optional<PerfilUsuario> getById(Long id) {
        return perfilusuarioDao.getById(id);
    }

    @Override
    public List<PerfilUsuario> getAll() {
        return perfilusuarioDao.getAll();
    }
}
