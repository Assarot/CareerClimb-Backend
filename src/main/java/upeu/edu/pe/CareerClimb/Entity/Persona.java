package upeu.edu.pe.CareerClimb.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "PERSONA")
public class Persona {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERSONA")
    @SequenceGenerator(name = "SQ_PERSONA", sequenceName = "SQ_PERSONA", allocationSize = 1)
	@Column(name = "idpersona",columnDefinition = "NUMBER")
	private Long idPersona;
	@Column(name = "nombres",columnDefinition = "varchar2(150)")
	private String nombres;
	@Column(name = "apellidos",columnDefinition = "varchar2(150)")
	private String apellidos;
	@Column(name = "dni",columnDefinition = "char(8)")
	private String dni;
	@Column(name = "telefono",columnDefinition = "varchar2(15)")
	private String telefono;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	@OneToMany(mappedBy = "persona")
	@JsonIgnore
	private List<PersonaDetalleCargo>personaDetalleCargos;
	
	@OneToMany(mappedBy = "persona")
	@JsonIgnore
	private List<Usuario>usuarios;
	
	@OneToMany(mappedBy = "persona")
	@JsonIgnore
	private List<DetallePPP>detallePPPs;
	
}
