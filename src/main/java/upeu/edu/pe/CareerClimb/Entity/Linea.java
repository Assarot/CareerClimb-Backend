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
@Table(name = "LINEA")
public class Linea {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LINEA")
    @SequenceGenerator(name = "SQ_LINEA", sequenceName = "SQ_LINEA", allocationSize = 1)
	@Column(name = "idlinea",columnDefinition = "NUMBER")
	private Long idLinea;
	@Column(name = "nombre",columnDefinition = "VARCHAR2(50)")
	private String nombre;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	@OneToMany(mappedBy = "linea")
	@JsonIgnore
	private List<PPPLinea>pppLineas;
}
