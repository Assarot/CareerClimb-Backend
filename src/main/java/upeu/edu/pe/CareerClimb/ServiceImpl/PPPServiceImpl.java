package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.PPPDao;
import upeu.edu.pe.CareerClimb.Entity.PPP;
import upeu.edu.pe.CareerClimb.Service.PPPService;

@Service
public class PPPServiceImpl implements PPPService {
    @Autowired
    private PPPDao pppDao;

    @Override
    public PPP create(PPP ppp) {
        return pppDao.create(ppp);
    }

    @Override
    public PPP update(PPP ppp) {
        return pppDao.update(ppp);
    }

    @Override
    public void delete(Long id) {
        pppDao.delete(id);
    }

    @Override
    public Optional<PPP> getById(Long id) {
        return pppDao.getById(id);
    }

    @Override
    public List<PPP> getAll() {
        return pppDao.getAll();
    }
}
