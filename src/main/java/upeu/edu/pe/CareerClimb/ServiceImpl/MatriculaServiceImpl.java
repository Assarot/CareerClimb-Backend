package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.CareerClimb.Dao.MatriculaDao;
import upeu.edu.pe.CareerClimb.Entity.Matricula;
import upeu.edu.pe.CareerClimb.Service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    @Autowired
    private MatriculaDao matriculaDao;

    @Override
    public Matricula create(Matricula matricula) {
        return matriculaDao.create(matricula);
    }

    @Override
    public Matricula update(Matricula matricula) {
        return matriculaDao.update(matricula);
    }

    @Override
    public void delete(Long id) {
        matriculaDao.delete(id);
    }

    @Override
    public Optional<Matricula> getById(Long id) {
        return matriculaDao.getById(id);
    }

    @Override
    public List<Matricula> getAll() {
        return matriculaDao.getAll();
    }
}
