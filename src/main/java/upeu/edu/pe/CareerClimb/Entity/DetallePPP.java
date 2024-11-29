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
@Table(name = "DETALLE_PPP")
public class DetallePPP {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DETALLE_PPP")
    @SequenceGenerator(name = "SQ_DETALLE_PPP", sequenceName = "SQ_DETALLE_PPP", allocationSize = 1)
	@Column(name = "iddetalle_ppp",columnDefinition = "NUMBER")
	private Long idDetallePPP;
	
	@ManyToOne
	@JoinColumn(name = "idrequerimiento")
	private Requerimiento requerimiento;
	
	@ManyToOne
	@JoinColumn(name = "idppp")
	private PPP ppp;
	
	
	@OneToMany(mappedBy = "detallePPP")
	@JsonIgnore
	private List<DetalleDoc>detalleDocs;
	
	
	@ManyToOne
	@JoinColumn(name = "idpersona")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name = "idproceso")
	private Proceso proceso;
}
