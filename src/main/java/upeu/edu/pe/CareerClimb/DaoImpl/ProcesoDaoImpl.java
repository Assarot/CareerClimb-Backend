package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.ProcesoDao;
import upeu.edu.pe.CareerClimb.Entity.Proceso;
import upeu.edu.pe.CareerClimb.Repository.ProcesoRepository;

@Component
public class ProcesoDaoImpl implements ProcesoDao {
    @Autowired
    private ProcesoRepository procesoRepository;

    @Override
    public Proceso create(Proceso proceso) {
        return procesoRepository.save(proceso);
    }

    @Override
    public Proceso update(Proceso proceso) {
        return procesoRepository.save(proceso);
    }

    @Override
    public void delete(Long id) {
        procesoRepository.deleteById(id);
    }

    @Override
    public Optional<Proceso> getById(Long id) {
        return procesoRepository.findById(id);
    }

    @Override
    public List<Proceso> getAll() {
        return procesoRepository.findAll();
    }
}
