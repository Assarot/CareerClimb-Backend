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
@Table(name = "CARGO")
public class Cargo {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CARGO")
    @SequenceGenerator(name = "SQ_CARGO", sequenceName = "SQ_CARGO", allocationSize = 1)
	@Column(name = "idcargo",columnDefinition = "NUMBER")
	private Long idCargo;
	@Column(name = "nombre",columnDefinition = "varchar(100)")
	private String nombre;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	@OneToMany(mappedBy = "cargo")
	@JsonIgnore
	private List<DetalleCargo>detalleCargos;
}
