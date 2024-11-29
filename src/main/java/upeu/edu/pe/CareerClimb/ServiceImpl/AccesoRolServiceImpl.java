package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.AccesoRolDao;
import upeu.edu.pe.CareerClimb.Entity.AccesoRol;
import upeu.edu.pe.CareerClimb.Service.AccesoRolService;

@Service
public class AccesoRolServiceImpl implements AccesoRolService {
    @Autowired
    private AccesoRolDao accesorolDao;

    @Override
    public AccesoRol create(AccesoRol accesorol) {
        return accesorolDao.create(accesorol);
    }

    @Override
    public AccesoRol update(AccesoRol accesorol) {
        return accesorolDao.update(accesorol);
    }

    @Override
    public void delete(Long id) {
        accesorolDao.delete(id);
    }

    @Override
    public Optional<AccesoRol> getById(Long id) {
        return accesorolDao.getById(id);
    }

    @Override
    public List<AccesoRol> getAll() {
        return accesorolDao.getAll();
    }

}
