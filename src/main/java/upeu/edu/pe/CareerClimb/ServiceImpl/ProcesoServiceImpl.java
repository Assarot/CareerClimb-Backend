package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.ProcesoDao;
import upeu.edu.pe.CareerClimb.Entity.Proceso;
import upeu.edu.pe.CareerClimb.Service.ProcesoService;

@Service
public class ProcesoServiceImpl implements ProcesoService {
    @Autowired
    private ProcesoDao procesoDao;

    @Override
    public Proceso create(Proceso proceso) {
        return procesoDao.create(proceso);
    }

    @Override
    public Proceso update(Proceso proceso) {
        return procesoDao.update(proceso);
    }

    @Override
    public void delete(Long id) {
        procesoDao.delete(id);
    }

    @Override
    public Optional<Proceso> getById(Long id) {
        return procesoDao.getById(id);
    }

    @Override
    public List<Proceso> getAll() {
        return procesoDao.getAll();
    }
}
