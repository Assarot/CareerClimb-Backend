package upeu.edu.pe.CareerClimb.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "ACCESO")
public class Acceso {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACCESO")
    @SequenceGenerator(name = "SQ_ACCESO", sequenceName = "SQ_ACCESO", allocationSize = 1)
	@Column(name = "idacceso",columnDefinition = "NUMBER")
	private Long idAcceso;
	@Column(name = "titulo",columnDefinition = "varchar2(500)")
	private String titulo;
	@Column(name = "url",columnDefinition = "varchar2(500)")
	private String url;
	@Column(name = "icono",columnDefinition = "varchar2(100)")
	private String icono;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	
	@OneToMany(mappedBy = "acceso")
	@JsonIgnore
	private List<AccesoRol>accesoRoles;
	
	@OneToMany(mappedBy = "accesoPadre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
    private List<Acceso> subAccesos;
	
	@ManyToOne
    @JoinColumn(name = "idacceso_padre",nullable = true) 
    private Acceso accesoPadre;
}
