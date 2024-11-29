package upeu.edu.pe.CareerClimb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.CareerClimb.Entity.Rol;
@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	Optional<Rol> findByNombre(String nombre);
}
