package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.PPPLineaDao;
import upeu.edu.pe.CareerClimb.Entity.PPPLinea;
import upeu.edu.pe.CareerClimb.Service.PPPLineaService;

@Service
public class PPPLineaServiceImpl implements PPPLineaService {
    @Autowired
    private PPPLineaDao ppplineaDao;

    @Override
    public PPPLinea create(PPPLinea ppplinea) {
        return ppplineaDao.create(ppplinea);
    }

    @Override
    public PPPLinea update(PPPLinea ppplinea) {
        return ppplineaDao.update(ppplinea);
    }

    @Override
    public void delete(Long id) {
        ppplineaDao.delete(id);
    }

    @Override
    public Optional<PPPLinea> getById(Long id) {
        return ppplineaDao.getById(id);
    }

    @Override
    public List<PPPLinea> getAll() {
        return ppplineaDao.getAll();
    }
}
