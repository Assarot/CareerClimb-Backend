package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.DetalleDocDao;
import upeu.edu.pe.CareerClimb.Entity.DetalleDoc;
import upeu.edu.pe.CareerClimb.Repository.DetalleDocRepository;

@Component
public class DetalleDocDaoImpl implements DetalleDocDao {
    @Autowired
    private DetalleDocRepository detalledocRepository;

    @Override
    public DetalleDoc create(DetalleDoc detalledoc) {
        return detalledocRepository.save(detalledoc);
    }

    @Override
    public DetalleDoc update(DetalleDoc detalledoc) {
        return detalledocRepository.save(detalledoc);
    }

    @Override
    public void delete(Long id) {
        detalledocRepository.deleteById(id);
    }

    @Override
    public Optional<DetalleDoc> getById(Long id) {
        return detalledocRepository.findById(id);
    }

    @Override
    public List<DetalleDoc> getAll() {
        return detalledocRepository.findAll();
    }
}
