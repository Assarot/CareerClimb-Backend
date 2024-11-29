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
@Table(name = "PLAN_CARRERA")
public class PlanCarrera {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PLAN_CARRERA")
    @SequenceGenerator(name = "SQ_PLAN_CARRERA", sequenceName = "SQ_PLAN_CARRERA", allocationSize = 1)
	@Column(name = "idplan_carrera",columnDefinition = "NUMBER")
	private Long idPlanCarrera;
	
	
	@ManyToOne
	@JoinColumn(name = "idplan")
	private Plan plan;
	
	@ManyToOne
	@JoinColumn(name = "idcarrera")
	private Carrera carrera;
	
	@OneToMany(mappedBy = "planCarrera")
	@JsonIgnore
	private List<PPP>ppps;
	
	@OneToMany(mappedBy = "planCarrera")
	@JsonIgnore
	private List<RequerimientoProceso> requerimientoProcesos;
	
	@OneToMany(mappedBy = "planCarrera")
	@JsonIgnore
	private List<DetalleEvaluacion>detalleEvaluaciones;
	
	@OneToMany(mappedBy = "planCarrera")
	@JsonIgnore
	private List<Matricula>matriculas;
	
}
