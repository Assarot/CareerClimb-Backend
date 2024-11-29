package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.LineaDao;
import upeu.edu.pe.CareerClimb.Entity.Linea;
import upeu.edu.pe.CareerClimb.Service.LineaService;

@Service
public class LineaServiceImpl implements LineaService {
    @Autowired
    private LineaDao lineaDao;

    @Override
    public Linea create(Linea linea) {
        return lineaDao.create(linea);
    }

    @Override
    public Linea update(Linea linea) {
        return lineaDao.update(linea);
    }

    @Override
    public void delete(Long id) {
        lineaDao.delete(id);
    }

    @Override
    public Optional<Linea> getById(Long id) {
        return lineaDao.getById(id);
    }

    @Override
    public List<Linea> getAll() {
        return lineaDao.getAll();
    }
}
