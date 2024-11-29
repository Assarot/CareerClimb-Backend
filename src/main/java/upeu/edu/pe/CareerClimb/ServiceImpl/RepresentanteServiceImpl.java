package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.RepresentanteDao;
import upeu.edu.pe.CareerClimb.Entity.Representante;
import upeu.edu.pe.CareerClimb.Service.RepresentanteService;

@Service
public class RepresentanteServiceImpl implements RepresentanteService {
    @Autowired
    private RepresentanteDao representanteDao;

    @Override
    public Representante create(Representante representante) {
        return representanteDao.create(representante);
    }

    @Override
    public Representante update(Representante representante) {
        return representanteDao.update(representante);
    }

    @Override
    public void delete(Long id) {
        representanteDao.delete(id);
    }

    @Override
    public Optional<Representante> getById(Long id) {
        return representanteDao.getById(id);
    }

    @Override
    public List<Representante> getAll() {
        return representanteDao.getAll();
    }
}
