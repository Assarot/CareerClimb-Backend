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
@Table(name = "PROCESO")
public class Proceso {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCESO")
    @SequenceGenerator(name = "SQ_PROCESO", sequenceName = "SQ_PROCESO", allocationSize = 1)
	@Column(name = "idproceso",columnDefinition = "NUMBER")
	private Long idProceso;
	@Column(name = "nombre",columnDefinition = "varchar2(100)")
	private String nombre;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	
	@OneToMany(mappedBy = "proceso")
	@JsonIgnore
	private List<RequerimientoProceso>requerimientoProcesos;
	
	@OneToMany(mappedBy = "proceso")
	@JsonIgnore
	private List<DetallePPP>detallePPPs;
	
}
