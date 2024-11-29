package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.LineaDao;
import upeu.edu.pe.CareerClimb.Entity.Linea;
import upeu.edu.pe.CareerClimb.Repository.LineaRepository;

@Component
public class LineaDaoImpl implements LineaDao {
    @Autowired
    private LineaRepository lineaRepository;

    @Override
    public Linea create(Linea linea) {
        return lineaRepository.save(linea);
    }

    @Override
    public Linea update(Linea linea) {
        return lineaRepository.save(linea);
    }

    @Override
    public void delete(Long id) {
        lineaRepository.deleteById(id);
    }

    @Override
    public Optional<Linea> getById(Long id) {
        return lineaRepository.findById(id);
    }

    @Override
    public List<Linea> getAll() {
        return lineaRepository.findAll();
    }
}
