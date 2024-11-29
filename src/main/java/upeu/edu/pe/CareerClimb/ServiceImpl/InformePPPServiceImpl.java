package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.InformePPPDao;
import upeu.edu.pe.CareerClimb.Entity.InformePPP;
import upeu.edu.pe.CareerClimb.Service.InformePPPService;

@Service
public class InformePPPServiceImpl implements InformePPPService {
    @Autowired
    private InformePPPDao informepppDao;

    @Override
    public InformePPP create(InformePPP informeppp) {
        return informepppDao.create(informeppp);
    }

    @Override
    public InformePPP update(InformePPP informeppp) {
        return informepppDao.update(informeppp);
    }

    @Override
    public void delete(Long id) {
        informepppDao.delete(id);
    }

    @Override
    public Optional<InformePPP> getById(Long id) {
        return informepppDao.getById(id);
    }

    @Override
    public List<InformePPP> getAll() {
        return informepppDao.getAll();
    }
}
