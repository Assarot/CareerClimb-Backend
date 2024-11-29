package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.InformePPPDao;
import upeu.edu.pe.CareerClimb.Entity.InformePPP;
import upeu.edu.pe.CareerClimb.Repository.InformePPPRepository;

@Component
public class InformePPPDaoImpl implements InformePPPDao {
    @Autowired
    private InformePPPRepository informepppRepository;

    @Override
    public InformePPP create(InformePPP informeppp) {
        return informepppRepository.save(informeppp);
    }

    @Override
    public InformePPP update(InformePPP informeppp) {
        return informepppRepository.save(informeppp);
    }

    @Override
    public void delete(Long id) {
        informepppRepository.deleteById(id);
    }

    @Override
    public Optional<InformePPP> getById(Long id) {
        return informepppRepository.findById(id);
    }

    @Override
    public List<InformePPP> getAll() {
        return informepppRepository.findAll();
    }
}
