package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.RequerimientoProcesoDao;
import upeu.edu.pe.CareerClimb.Entity.RequerimientoProceso;
import upeu.edu.pe.CareerClimb.Service.RequerimientoProcesoService;

@Service
public class RequerimientoProcesoServiceImpl implements RequerimientoProcesoService {
    @Autowired
    private RequerimientoProcesoDao requerimientoprocesoDao;

    @Override
    public RequerimientoProceso create(RequerimientoProceso requerimientoproceso) {
        return requerimientoprocesoDao.create(requerimientoproceso);
    }

    @Override
    public RequerimientoProceso update(RequerimientoProceso requerimientoproceso) {
        return requerimientoprocesoDao.update(requerimientoproceso);
    }

    @Override
    public void delete(Long id) {
        requerimientoprocesoDao.delete(id);
    }

    @Override
    public Optional<RequerimientoProceso> getById(Long id) {
        return requerimientoprocesoDao.getById(id);
    }

    @Override
    public List<RequerimientoProceso> getAll() {
        return requerimientoprocesoDao.getAll();
    }
}
