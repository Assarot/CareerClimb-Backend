package upeu.edu.pe.CareerClimb.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "CONTROL")
public class Control {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONTROL")
    @SequenceGenerator(name = "SQ_CONTROL", sequenceName = "SQ_CONTROL", allocationSize = 1)
	@Column(name = "idcontrol",columnDefinition = "NUMBER")
	private Long idControl;
	@Column(name = "usuario",columnDefinition = "VARCHAR2(100)")
	private String usuario;
	@Column(name = "tabla",columnDefinition = "VARCHAR2(100)")
	private String tabla;
	@Column(name = "accion",columnDefinition = "VARCHAR2(20)")
	private String accion;
	@Column(name = "datos",columnDefinition = "VARCHAR2(3000)")
	private String datos;
	@Column(name = "fecha",columnDefinition = "DATE")
	private String fecha;
	@Column(name = "ip",columnDefinition = "VARCHAR2(50)")
	private String ip;
	@Column(name = "restauracion",columnDefinition = "VARCHAR2(4000)")
	private String restauracion;
}
