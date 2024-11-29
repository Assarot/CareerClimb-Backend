package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.PerfilUsuarioDao;
import upeu.edu.pe.CareerClimb.Entity.PerfilUsuario;
import upeu.edu.pe.CareerClimb.Repository.PerfilUsuarioRepository;

@Component
public class PerfilUsuarioDaoImpl implements PerfilUsuarioDao {
    @Autowired
    private PerfilUsuarioRepository perfilusuarioRepository;

    @Override
    public PerfilUsuario create(PerfilUsuario perfilusuario) {
        return perfilusuarioRepository.save(perfilusuario);
    }

    @Override
    public PerfilUsuario update(PerfilUsuario perfilusuario) {
        return perfilusuarioRepository.save(perfilusuario);
    }

    @Override
    public void delete(Long id) {
        perfilusuarioRepository.deleteById(id);
    }

    @Override
    public Optional<PerfilUsuario> getById(Long id) {
        return perfilusuarioRepository.findById(id);
    }

    @Override
    public List<PerfilUsuario> getAll() {
        return perfilusuarioRepository.findAll();
    }
}
