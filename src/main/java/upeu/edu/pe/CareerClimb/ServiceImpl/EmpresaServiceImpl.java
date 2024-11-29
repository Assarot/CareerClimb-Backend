package upeu.edu.pe.CareerClimb.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import upeu.edu.pe.CareerClimb.Dao.EmpresaDao;
import upeu.edu.pe.CareerClimb.Entity.Empresa;
import upeu.edu.pe.CareerClimb.Service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private EmpresaDao empresaDao;

    @Override
    public Empresa create(Empresa empresa) {
        return empresaDao.create(empresa);
    }

    @Override
    public Empresa update(Empresa empresa) {
        return empresaDao.update(empresa);
    }

    @Override
    public void delete(Long id) {
        empresaDao.delete(id);
    }

    @Override
    public Optional<Empresa> getById(Long id) {
        return empresaDao.getById(id);
    }

    @Override
    public List<Empresa> getAll() {
        return empresaDao.getAll();
    }
    
    @Transactional
    @Override
    public void deleteEmpresa(String empresaRuc) {
        empresaDao.deleteEmpresa(empresaRuc);
    }
}
