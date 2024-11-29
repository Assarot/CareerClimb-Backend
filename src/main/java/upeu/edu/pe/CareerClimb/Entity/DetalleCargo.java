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
@Table(name = "DETALLE_CARGO")
public class DetalleCargo {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DETALLE_CARGO")
    @SequenceGenerator(name = "SQ_DETALLE_CARGO", sequenceName = "SQ_DETALLE_CARGO", allocationSize = 1)
	@Column(name = "iddetalle_cargo",columnDefinition = "NUMBER")
	private Long idDetalleCargo;
	@Column(name = "detalle",columnDefinition = "varchar(200)")
	private String detalle;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive;
	
	@ManyToOne
	@JoinColumn(name = "idcargo")
	private Cargo cargo;
	
	@OneToMany(mappedBy = "detallecargo")
	@JsonIgnore
	private List<PersonaDetalleCargo>personaDetalleCargos;
}
