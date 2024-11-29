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
@Table(name = "REQUERIMIENTO")
public class Requerimiento {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_REQUERIMIENTO")
    @SequenceGenerator(name = "SQ_REQUERIMIENTO", sequenceName = "SQ_REQUERIMIENTO", allocationSize = 1)
	@Column(name = "idrequerimiento",columnDefinition = "NUMBER")
	private Long idRequerimiento;
	@Column(name = "nombre",columnDefinition = "varchar2(100)")
	private String nombre;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';

	
	@OneToMany(mappedBy = "requerimiento")
	@JsonIgnore
	private List<RequerimientoProceso>requerimientoProcesos;
}
