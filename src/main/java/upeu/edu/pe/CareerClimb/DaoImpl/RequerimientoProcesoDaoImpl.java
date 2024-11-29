package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.RequerimientoProcesoDao;
import upeu.edu.pe.CareerClimb.Entity.RequerimientoProceso;
import upeu.edu.pe.CareerClimb.Repository.RequerimientoProcesoRepository;

@Component
public class RequerimientoProcesoDaoImpl implements RequerimientoProcesoDao {
    @Autowired
    private RequerimientoProcesoRepository requerimientoprocesoRepository;

    @Override
    public RequerimientoProceso create(RequerimientoProceso requerimientoproceso) {
        return requerimientoprocesoRepository.save(requerimientoproceso);
    }

    @Override
    public RequerimientoProceso update(RequerimientoProceso requerimientoproceso) {
        return requerimientoprocesoRepository.save(requerimientoproceso);
    }

    @Override
    public void delete(Long id) {
        requerimientoprocesoRepository.deleteById(id);
    }

    @Override
    public Optional<RequerimientoProceso> getById(Long id) {
        return requerimientoprocesoRepository.findById(id);
    }

    @Override
    public List<RequerimientoProceso> getAll() {
        return requerimientoprocesoRepository.findAll();
    }
}
