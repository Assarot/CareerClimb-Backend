package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.RequerimientoDao;
import upeu.edu.pe.CareerClimb.Entity.Requerimiento;
import upeu.edu.pe.CareerClimb.Service.RequerimientoService;

@Service
public class RequerimientoServiceImpl implements RequerimientoService {
    @Autowired
    private RequerimientoDao requerimientoDao;

    @Override
    public Requerimiento create(Requerimiento requerimiento) {
        return requerimientoDao.create(requerimiento);
    }

    @Override
    public Requerimiento update(Requerimiento requerimiento) {
        return requerimientoDao.update(requerimiento);
    }

    @Override
    public void delete(Long id) {
        requerimientoDao.delete(id);
    }

    @Override
    public Optional<Requerimiento> getById(Long id) {
        return requerimientoDao.getById(id);
    }

    @Override
    public List<Requerimiento> getAll() {
        return requerimientoDao.getAll();
    }
}
