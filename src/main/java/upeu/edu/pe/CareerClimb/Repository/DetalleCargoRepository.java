package upeu.edu.pe.CareerClimb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.CareerClimb.Entity.DetalleCargo;
@Repository
public interface DetalleCargoRepository extends JpaRepository<DetalleCargo, Long> {

}
