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
@Table(name = "DETALLE_DOC")
public class DetalleDoc {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DETALLE_DOC")
    @SequenceGenerator(name = "SQ_DETALLE_DOC", sequenceName = "SQ_DETALLE_DOC", allocationSize = 1)
	@Column(name = "iddetalle_doc",columnDefinition = "NUMBER")
	private Long idDetalleDoc;
	@Column(name = "nombre",columnDefinition = "varchar2(200)")
	private String nombre;
	@Column(name = "motivo_rechazo",columnDefinition = "VARCHAR2(800)",nullable = true)
	private String motivoRechazo;
	@Column(name = "estado",columnDefinition = "varchar2(20)")
	private String estado;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive;
		
	@ManyToOne
	@JoinColumn(name = "iddetalle_ppp")
	private DetallePPP detallePPP;
	
	@OneToMany(mappedBy = "detalleDoc")
	@JsonIgnore
	private List<Doc>docs;
	
	public DetalleDoc(Long id) {
        this.idDetalleDoc = id;
    }
}
