package upeu.edu.pe.CareerClimb.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "MATRICULA")
public class Matricula {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MATRICULA")
    @SequenceGenerator(name = "SQ_MATRICULA", sequenceName = "SQ_MATRICULA", allocationSize = 1)
	@Column(name = "idmatricula",columnDefinition = "NUMBER")
	private Long idMatricula;
	@Column(name = "periodo",columnDefinition = "varchar2(20)")
	private String periodo;
	@Column(name = "estado",columnDefinition = "varchar2(20)")
	private String estado;
	@Column(name = "descripcion",columnDefinition = "varchar2(500)")
	private String descripcion;
	@Column(name = "dni",columnDefinition = "char(8)")
	private String dni;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	@OneToMany(mappedBy = "matricula")
	@JsonIgnore
	private List<Solicitud>solicitudes;
	
	@ManyToOne
	@JoinColumn(name = "idplan_carrera")
	private PlanCarrera planCarrera;
	
}
