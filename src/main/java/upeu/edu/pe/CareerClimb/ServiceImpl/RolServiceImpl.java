package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.RolDao;
import upeu.edu.pe.CareerClimb.Entity.Acceso;
import upeu.edu.pe.CareerClimb.Entity.Rol;
import upeu.edu.pe.CareerClimb.Service.RolService;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolDao rolDao;

    @Override
    public Rol create(Rol rol) {
        return rolDao.create(rol);
    }

    @Override
    public Rol update(Rol rol) {
        return rolDao.update(rol);
    }

    @Override
    public void delete(Long id) {
        rolDao.delete(id);
    }

    @Override
    public Optional<Rol> getById(Long id) {
        return rolDao.getById(id);
    }

    @Override
    public List<Rol> getAll() {
        return rolDao.getAll();
    }

}
