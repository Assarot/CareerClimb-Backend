package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.RubroDao;
import upeu.edu.pe.CareerClimb.Entity.Rubro;
import upeu.edu.pe.CareerClimb.Service.RubroService;

@Service
public class RubroServiceImpl implements RubroService {
    @Autowired
    private RubroDao rubroDao;

    @Override
    public Rubro create(Rubro rubro) {
        return rubroDao.create(rubro);
    }

    @Override
    public Rubro update(Rubro rubro) {
        return rubroDao.update(rubro);
    }

    @Override
    public void delete(Long id) {
        rubroDao.delete(id);
    }

    @Override
    public Optional<Rubro> getById(Long id) {
        return rubroDao.getById(id);
    }

    @Override
    public List<Rubro> getAll() {
        return rubroDao.getAll();
    }
}
