package upeu.edu.pe.CareerClimb.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.EmpresaDao;
import upeu.edu.pe.CareerClimb.Entity.Empresa;
import upeu.edu.pe.CareerClimb.Repository.EmpresaRepository;

@Component
public class EmpresaDaoImpl implements EmpresaDao {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa create(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa update(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public Optional<Empresa> getById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    @Override
    public void deleteEmpresa(String empresaRuc) {
        empresaRepository.deleteEmpresa(empresaRuc);
    }
}
