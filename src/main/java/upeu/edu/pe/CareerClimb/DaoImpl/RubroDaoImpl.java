package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.RubroDao;
import upeu.edu.pe.CareerClimb.Entity.Rubro;
import upeu.edu.pe.CareerClimb.Repository.RubroRepository;

@Component
public class RubroDaoImpl implements RubroDao {
    @Autowired
    private RubroRepository rubroRepository;

    @Override
    public Rubro create(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    @Override
    public Rubro update(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    @Override
    public void delete(Long id) {
        rubroRepository.deleteById(id);
    }

    @Override
    public Optional<Rubro> getById(Long id) {
        return rubroRepository.findById(id);
    }

    @Override
    public List<Rubro> getAll() {
        return rubroRepository.findAll();
    }
}
