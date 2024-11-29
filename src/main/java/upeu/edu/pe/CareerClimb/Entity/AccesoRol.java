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
@Table(name = "ACCESO_ROL")
public class AccesoRol {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACCESO_ROL")
    @SequenceGenerator(name = "SQ_ACCESO_ROL", sequenceName = "SQ_ACCESO_ROL", allocationSize = 1)
	@Column(name = "idacceso_rol",columnDefinition = "NUMBER")
	private Long idAccesoRol; 
	
	@ManyToOne
	@JoinColumn(name = "idrol")
	private Rol rol;
	
	
	@ManyToOne
	@JoinColumn(name = "idacceso")
	private Acceso acceso;
}
