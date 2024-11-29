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
@Table(name = "ROL")
public class Rol {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ROL")
    @SequenceGenerator(name = "SQ_ROL", sequenceName = "SQ_ROL", allocationSize = 1)
	@Column(name = "idrol",columnDefinition = "NUMBER")
	private Long idRol;
	@Column(name = "nombre",columnDefinition = "varchar(100)")
	private String nombre;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	
	
	@OneToMany(mappedBy = "rol")
	@JsonIgnore
	private List<AccesoRol>accesoRoles;
	
	@OneToMany(mappedBy = "rol")
	@JsonIgnore
	private List<UsuarioRol>usuarioRoles;

}
