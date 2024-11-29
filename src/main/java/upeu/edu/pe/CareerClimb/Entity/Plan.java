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
@Table(name = "PLAN")
public class Plan {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PLAN")
    @SequenceGenerator(name = "SQ_PLAN", sequenceName = "SQ_PLAN", allocationSize = 1)
	@Column(name = "idplan", columnDefinition = "NUMBER")
	private Long idPlan;
	@Column(name = "plan",columnDefinition = "varchar2(15)")
	private String plan;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';

	
	@OneToMany(mappedBy = "plan")
	@JsonIgnore
	private List<PlanCarrera>planCarreras;
}
