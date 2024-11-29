package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.RolDao;
import upeu.edu.pe.CareerClimb.Entity.Acceso;
import upeu.edu.pe.CareerClimb.Entity.Rol;
import upeu.edu.pe.CareerClimb.Repository.RolRepository;

@Component
public class RolDaoImpl implements RolDao {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public Rol create(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void delete(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public Optional<Rol> getById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

}
