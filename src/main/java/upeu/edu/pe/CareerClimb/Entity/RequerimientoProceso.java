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
@Table(name = "REQUERIMIENTO_PROCESO")
public class RequerimientoProceso {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_REQUERIMIENTO_PROCESO")
    @SequenceGenerator(name = "SQ_REQUERIMIENTO_PROCESO", sequenceName = "SQ_REQUERIMIENTO_PROCESO", allocationSize = 1)
	@Column(name = "idrequerimiento_proceso",columnDefinition = "NUMBER")
	private Long idRequerimientoProceso;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	
	@ManyToOne
	@JoinColumn(name = "idproceso")
	private Proceso proceso;
	
	@ManyToOne
	@JoinColumn(name = "idrequerimiento")
	private Requerimiento requerimiento;
	
	@ManyToOne
	@JoinColumn(name = "idplan_carrera")
	private PlanCarrera planCarrera;
	
}
