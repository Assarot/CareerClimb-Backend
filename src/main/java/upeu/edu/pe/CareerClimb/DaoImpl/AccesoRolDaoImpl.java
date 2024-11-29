package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.AccesoRolDao;
import upeu.edu.pe.CareerClimb.Entity.AccesoRol;
import upeu.edu.pe.CareerClimb.Repository.AccesoRolRepository;

@Component
public class AccesoRolDaoImpl implements AccesoRolDao {
    @Autowired
    private AccesoRolRepository accesorolRepository;

    @Override
    public AccesoRol create(AccesoRol accesorol) {
        return accesorolRepository.save(accesorol);
    }

    @Override
    public AccesoRol update(AccesoRol accesorol) {
        return accesorolRepository.save(accesorol);
    }

    @Override
    public void delete(Long id) {
        accesorolRepository.deleteById(id);
    }

    @Override
    public Optional<AccesoRol> getById(Long id) {
        return accesorolRepository.findById(id);
    }

    @Override
    public List<AccesoRol> getAll() {
        return accesorolRepository.findAll();
    }
}
