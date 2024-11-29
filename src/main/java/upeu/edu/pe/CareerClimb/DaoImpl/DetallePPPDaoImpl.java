package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.DetallePPPDao;
import upeu.edu.pe.CareerClimb.Entity.DetallePPP;
import upeu.edu.pe.CareerClimb.Repository.DetallePPPRepository;

@Component
public class DetallePPPDaoImpl implements DetallePPPDao {
    @Autowired
    private DetallePPPRepository detallepppRepository;

    @Override
    public DetallePPP create(DetallePPP detalleppp) {
        return detallepppRepository.save(detalleppp);
    }

    @Override
    public DetallePPP update(DetallePPP detalleppp) {
        return detallepppRepository.save(detalleppp);
    }

    @Override
    public void delete(Long id) {
        detallepppRepository.deleteById(id);
    }

    @Override
    public Optional<DetallePPP> getById(Long id) {
        return detallepppRepository.findById(id);
    }

    @Override
    public List<DetallePPP> getAll() {
        return detallepppRepository.findAll();
    }
}
