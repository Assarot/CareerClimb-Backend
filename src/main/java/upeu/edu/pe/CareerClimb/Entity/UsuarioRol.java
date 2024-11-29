package upeu.edu.pe.CareerClimb.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "USUARIO_ROL")
public class UsuarioRol {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO_ROL")
    @SequenceGenerator(name = "SQ_USUARIO_ROL", sequenceName = "SQ_USUARIO_ROL", allocationSize = 1)
	@Column(name = "idusuario_rol",columnDefinition = "NUMBER")
	private Long idUsuarioRol;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idrol")
	private Rol rol;
}
