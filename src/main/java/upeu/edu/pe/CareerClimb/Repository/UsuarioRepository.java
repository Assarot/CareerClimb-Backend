package upeu.edu.pe.CareerClimb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.CareerClimb.Entity.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
    
    @Query(value = "SELECT generar_nombre_usuario(:idPersona) FROM dual", nativeQuery = true)
    String generarNombreUsuario(Long idPersona);
}
