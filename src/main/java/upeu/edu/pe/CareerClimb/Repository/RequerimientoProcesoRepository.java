package upeu.edu.pe.CareerClimb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.CareerClimb.Entity.RequerimientoProceso;
@Repository
public interface RequerimientoProcesoRepository extends JpaRepository<RequerimientoProceso, Long> {

}
