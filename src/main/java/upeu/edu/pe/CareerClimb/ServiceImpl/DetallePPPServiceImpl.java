package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.DetallePPPDao;
import upeu.edu.pe.CareerClimb.Entity.DetallePPP;
import upeu.edu.pe.CareerClimb.Service.DetallePPPService;

@Service
public class DetallePPPServiceImpl implements DetallePPPService {
    @Autowired
    private DetallePPPDao detallepppDao;

    @Override
    public DetallePPP create(DetallePPP detalleppp) {
        return detallepppDao.create(detalleppp);
    }

    @Override
    public DetallePPP update(DetallePPP detalleppp) {
        return detallepppDao.update(detalleppp);
    }

    @Override
    public void delete(Long id) {
        detallepppDao.delete(id);
    }

    @Override
    public Optional<DetallePPP> getById(Long id) {
        return detallepppDao.getById(id);
    }

    @Override
    public List<DetallePPP> getAll() {
        return detallepppDao.getAll();
    }
}
