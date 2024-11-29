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
@Table(name = "USUARIO")
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1)
	@Column(name = "idusuario",columnDefinition = "NUMBER")
	private Long idUsuario;
	@Column(name = "username",columnDefinition = "varchar2(100)")
	private String username;
	@Column(name = "email",columnDefinition = "varchar2(320)")
	private String email;
	@Column(name = "password",columnDefinition = "varchar2(200)")
	private String password;
	@Column(name = "is_active",columnDefinition = "char(1)")
	private char isActive='A';
	

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<UsuarioRol> usuarioRoles;


	
	@ManyToOne
	@JoinColumn(name = "idpersona")
	private Persona persona;
	
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<PerfilUsuario>perfilUsuarios;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RefreshToken> refreshTokens;

}
