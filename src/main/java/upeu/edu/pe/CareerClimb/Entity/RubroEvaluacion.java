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
@Table(name = "RUBRO_EVALUACION")
public class RubroEvaluacion {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RUBRO_EVALUACION")
    @SequenceGenerator(name = "SQ_RUBRO_EVALUACION", sequenceName = "SQ_RUBRO_EVALUACION", allocationSize = 1)
	@Column(name = "idrubro_evaluacion",columnDefinition = "NUMBER")
	private Long idRubroEvaluacion;
	@Column(name = "nota",columnDefinition = "DECIMAL")
	private String nota;
	
	@ManyToOne
	@JoinColumn(name = "idrubro")
	private Rubro rubro;
	
	@ManyToOne
	@JoinColumn(name = "idevaluacion")
	private Evaluacion evaluacion;
}
