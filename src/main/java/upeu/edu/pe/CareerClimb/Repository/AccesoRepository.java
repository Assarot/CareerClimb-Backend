	package upeu.edu.pe.CareerClimb.Repository;
	
	
import java.util.List;
	
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.CareerClimb.Entity.Acceso;
@Repository
public interface AccesoRepository extends JpaRepository<Acceso, Long> {
			
	@Query(value = "SELECT DISTINCT a.* " +
            "FROM \"ACCESO\" a " +
            "LEFT JOIN \"ACCESO_ROL\" ar ON a.\"IDACCESO\" = ar.\"IDACCESO\" " +
            "LEFT JOIN \"ROL\" r ON ar.\"IDROL\" = r.\"IDROL\" " +
            "WHERE r.\"NOMBRE\" = :rol AND a.\"IS_ACTIVE\" = 'A' " +
            "UNION ALL " +
            "SELECT DISTINCT sa.* " +
            "FROM \"ACCESO\" sa " +
            "JOIN \"ACCESO\" a ON sa.\"IDACCESO_PADRE\" = a.\"IDACCESO\" " +
            "LEFT JOIN \"ACCESO_ROL\" ar ON a.\"IDACCESO\" = ar.\"IDACCESO\" " +
            "LEFT JOIN \"ROL\" r ON ar.\"IDROL\" = r.\"IDROL\" " +
            "WHERE r.\"NOMBRE\" = :rol AND sa.\"IS_ACTIVE\" = 'A' ", nativeQuery = true)
List<Acceso> findAccesosByRol(@Param("rol") String rol);



}
