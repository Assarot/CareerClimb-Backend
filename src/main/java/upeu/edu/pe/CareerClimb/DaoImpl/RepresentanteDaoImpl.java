package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.RepresentanteDao;
import upeu.edu.pe.CareerClimb.Entity.Representante;
import upeu.edu.pe.CareerClimb.Repository.RepresentanteRepository;

@Component
public class RepresentanteDaoImpl implements RepresentanteDao {
    @Autowired
    private RepresentanteRepository representanteRepository;

    @Override
    public Representante create(Representante representante) {
        return representanteRepository.save(representante);
    }

    @Override
    public Representante update(Representante representante) {
        return representanteRepository.save(representante);
    }

    @Override
    public void delete(Long id) {
        representanteRepository.deleteById(id);
    }

    @Override
    public Optional<Representante> getById(Long id) {
        return representanteRepository.findById(id);
    }

    @Override
    public List<Representante> getAll() {
        return representanteRepository.findAll();
    }
}
