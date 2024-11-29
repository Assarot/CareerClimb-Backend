package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.MatriculaDao;
import upeu.edu.pe.CareerClimb.Entity.Matricula;
import upeu.edu.pe.CareerClimb.Repository.MatriculaRepository;

@Component
public class MatriculaDaoImpl implements MatriculaDao {
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public Matricula create(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula update(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }

    @Override
    public Optional<Matricula> getById(Long id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }
}
