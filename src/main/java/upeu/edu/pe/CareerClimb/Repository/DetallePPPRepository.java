package upeu.edu.pe.CareerClimb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.CareerClimb.Entity.DetallePPP;
@Repository
public interface DetallePPPRepository extends JpaRepository<DetallePPP, Long> {

}