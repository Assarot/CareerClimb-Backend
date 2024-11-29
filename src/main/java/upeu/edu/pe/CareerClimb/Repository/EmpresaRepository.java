package upeu.edu.pe.CareerClimb.Repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import upeu.edu.pe.CareerClimb.Entity.Empresa;
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	@Modifying
	@Transactional
	@Procedure(procedureName = "sp_delete_empresa_by_ruc")
	void deleteEmpresa(@Param("empresaRuc") String empresaRuc);
}
