package upeu.edu.pe.CareerClimb.Dao;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.CareerClimb.Entity.Empresa;

public interface EmpresaDao {
    Empresa create(Empresa empresa);
    Empresa update(Empresa empresa);
    void delete(Long id);
    Optional<Empresa> getById(Long id);
    List<Empresa> getAll();
    void deleteEmpresa(String empresaRuc);
}
