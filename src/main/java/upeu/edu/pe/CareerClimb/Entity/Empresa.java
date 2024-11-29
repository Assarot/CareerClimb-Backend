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
@Table(name = "EMPRESA")
public class Empresa {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EMPRESA")
    @SequenceGenerator(name = "SQ_EMPRESA", sequenceName = "SQ_EMPRESA", allocationSize = 1)
	@Column(name = "idempresa",columnDefinition = "NUMBER")
	private Long idEmpresa;
	@Column(name = "razon_social",columnDefinition = "varchar2(250)")
	private String razonSocial;
	@Column(name = "ruc",columnDefinition = "varchar2(11)",unique = true)
	private String ruc;
	@Column(name = "email",columnDefinition = "varchar2(320)")
	private String email;
	@Column(name = "telefono",columnDefinition = "varchar2(15)")
	private String telefono;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	@OneToMany(mappedBy = "empresa")
	@JsonIgnore
	private List<PPP>ppps;
	
	@OneToMany(mappedBy = "empresa")
	@JsonIgnore
	private List<Representante>representantes;
}
