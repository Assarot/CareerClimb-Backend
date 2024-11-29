package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.RequerimientoDao;
import upeu.edu.pe.CareerClimb.Entity.Requerimiento;
import upeu.edu.pe.CareerClimb.Repository.RequerimientoRepository;

@Component
public class RequerimientoDaoImpl implements RequerimientoDao {
    @Autowired
    private RequerimientoRepository requerimientoRepository;

    @Override
    public Requerimiento create(Requerimiento requerimiento) {
        return requerimientoRepository.save(requerimiento);
    }

    @Override
    public Requerimiento update(Requerimiento requerimiento) {
        return requerimientoRepository.save(requerimiento);
    }

    @Override
    public void delete(Long id) {
        requerimientoRepository.deleteById(id);
    }

    @Override
    public Optional<Requerimiento> getById(Long id) {
        return requerimientoRepository.findById(id);
    }

    @Override
    public List<Requerimiento> getAll() {
        return requerimientoRepository.findAll();
    }
}
