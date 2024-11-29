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
@Table(name = "REPRESENTANTE")
public class Representante {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_REPRESENTANTE")
    @SequenceGenerator(name = "SQ_REPRESENTANTE", sequenceName = "SQ_REPRESENTANTE", allocationSize = 1)
	@Column(name = "idrepresentante",columnDefinition = "NUMBER")
	private Long idRepresentante;
	@Column(name = "nombre",columnDefinition = "varchar2(500)")
	private String nombre;
	@Column(name = "email_corp",columnDefinition = "varchar2(320)")
	private String emailCorp;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	
	@ManyToOne
	@JoinColumn(name = "idempresa")
	private Empresa empresa;
	
	
}
