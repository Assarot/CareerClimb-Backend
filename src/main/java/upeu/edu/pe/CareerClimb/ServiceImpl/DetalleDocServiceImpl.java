package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.DetalleDocDao;
import upeu.edu.pe.CareerClimb.Entity.DetalleDoc;
import upeu.edu.pe.CareerClimb.Service.DetalleDocService;

@Service
public class DetalleDocServiceImpl implements DetalleDocService {
    @Autowired
    private DetalleDocDao detalledocDao;

    @Override
    public DetalleDoc create(DetalleDoc detalledoc) {
        return detalledocDao.create(detalledoc);
    }

    @Override
    public DetalleDoc update(DetalleDoc detalledoc) {
        return detalledocDao.update(detalledoc);
    }

    @Override
    public void delete(Long id) {
        detalledocDao.delete(id);
    }

    @Override
    public Optional<DetalleDoc> getById(Long id) {
        return detalledocDao.getById(id);
    }

    @Override
    public List<DetalleDoc> getAll() {
        return detalledocDao.getAll();
    }
}
