package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.AccesoDao;
import upeu.edu.pe.CareerClimb.Entity.Acceso;
import upeu.edu.pe.CareerClimb.Repository.AccesoRepository;

@Component
public class AccesoDaoImpl implements AccesoDao {
    @Autowired
    private AccesoRepository accesoRepository;

    @Override
    public Acceso create(Acceso acceso) {
        return accesoRepository.save(acceso);
    }

    @Override
    public Acceso update(Acceso acceso) {
        return accesoRepository.save(acceso);
    }

    @Override
    public void delete(Long id) {
        accesoRepository.deleteById(id);
    }

    @Override
    public Optional<Acceso> getById(Long id) {
        return accesoRepository.findById(id);
    }

    @Override
    public List<Acceso> getAll() {
        return accesoRepository.findAll();
    }

	@Override
	public List<Acceso> findAccesosByRol(String rol) {
		// TODO Auto-generated method stub
		return accesoRepository.findAccesosByRol(rol);
	}

	
}
