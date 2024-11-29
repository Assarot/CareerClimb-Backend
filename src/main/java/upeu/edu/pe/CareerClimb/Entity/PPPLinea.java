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
@Table(name = "PPP_LINEA")
public class PPPLinea {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PPP_LINEA")
    @SequenceGenerator(name = "SQ_PPP_LINEA", sequenceName = "SQ_PPP_LINEA", allocationSize = 1)
	@Column(name = "idPPPLinea",columnDefinition = "NUMBER")
	private Long idPPPLinea;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	@ManyToOne
	@JoinColumn(name = "idLinea")
	private Linea linea;
	
	@ManyToOne
	@JoinColumn(name = "IdPPP")
	private PPP ppp;
}
