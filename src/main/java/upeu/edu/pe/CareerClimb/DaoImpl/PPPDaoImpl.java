package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.PPPDao;
import upeu.edu.pe.CareerClimb.Entity.PPP;
import upeu.edu.pe.CareerClimb.Repository.PPPRepository;

@Component
public class PPPDaoImpl implements PPPDao {
    @Autowired
    private PPPRepository pppRepository;

    @Override
    public PPP create(PPP ppp) {
        return pppRepository.save(ppp);
    }

    @Override
    public PPP update(PPP ppp) {
        return pppRepository.save(ppp);
    }

    @Override
    public void delete(Long id) {
        pppRepository.deleteById(id);
    }

    @Override
    public Optional<PPP> getById(Long id) {
        return pppRepository.findById(id);
    }

    @Override
    public List<PPP> getAll() {
        return pppRepository.findAll();
    }
}
