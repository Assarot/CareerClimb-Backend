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
@Table(name = "DETALLE_EVALUACION")
public class DetalleEvaluacion {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DETALLE_EVALUACION")
    @SequenceGenerator(name = "SQ_DETALLE_EVALUACION", sequenceName = "SQ_DETALLE_EVALUACION", allocationSize = 1)
	@Column(name = "iddetalle_evaluacion",columnDefinition = "NUMBER")
	private Long idDetalleEvaluacion;
	
	
	@ManyToOne
	@JoinColumn(name = "idrubro")
	private Rubro rubro;
	
	@ManyToOne
	@JoinColumn(name = "idplan_carrera")
	private PlanCarrera planCarrera;
}
