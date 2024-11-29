package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.PPPLineaDao;
import upeu.edu.pe.CareerClimb.Entity.PPPLinea;
import upeu.edu.pe.CareerClimb.Repository.PPPLineaRepository;

@Component
public class PPPLineaDaoImpl implements PPPLineaDao {
    @Autowired
    private PPPLineaRepository ppplineaRepository;

    @Override
    public PPPLinea create(PPPLinea ppplinea) {
        return ppplineaRepository.save(ppplinea);
    }

    @Override
    public PPPLinea update(PPPLinea ppplinea) {
        return ppplineaRepository.save(ppplinea);
    }

    @Override
    public void delete(Long id) {
        ppplineaRepository.deleteById(id);
    }

    @Override
    public Optional<PPPLinea> getById(Long id) {
        return ppplineaRepository.findById(id);
    }

    @Override
    public List<PPPLinea> getAll() {
        return ppplineaRepository.findAll();
    }
}
