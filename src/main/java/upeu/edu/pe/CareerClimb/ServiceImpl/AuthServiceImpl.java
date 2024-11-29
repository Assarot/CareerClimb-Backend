package upeu.edu.pe.CareerClimb.ServiceImpl;

import upeu.edu.pe.CareerClimb.config.JwtTokenProvider;
import upeu.edu.pe.CareerClimb.dto.LoginDto;
import upeu.edu.pe.CareerClimb.dto.RegisterDto;
import upeu.edu.pe.CareerClimb.Entity.Persona;
import upeu.edu.pe.CareerClimb.Entity.RefreshToken;
import upeu.edu.pe.CareerClimb.Entity.Rol;
import upeu.edu.pe.CareerClimb.Entity.Usuario;
import upeu.edu.pe.CareerClimb.Entity.UsuarioRol;
import upeu.edu.pe.CareerClimb.Repository.PersonaRepository;
import upeu.edu.pe.CareerClimb.Repository.RolRepository;
import upeu.edu.pe.CareerClimb.Repository.UsuarioRepository;
import upeu.edu.pe.CareerClimb.Service.AuthService;
import upeu.edu.pe.CareerClimb.Dao.RefreshTokenDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.*;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private RefreshTokenDao refreshTokenDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> login(LoginDto loginDto) {
        // 1. Autenticar usuario
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 2. Buscar el usuario para incluir datos adicionales en los tokens
        Usuario usuario = usuarioRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        String nombreCompleto = usuario.getPersona().getNombres() + " " + usuario.getPersona().getApellidos();

        // 3. Generar Access Token
        String accessToken = jwtTokenProvider.generateToken(authentication, nombreCompleto);

        // 4. Generar Refresh Token
        String refreshToken = jwtTokenProvider.generateRefreshToken(usuario.getUsername());

        // 5. Guardar Refresh Token en la base de datos
        RefreshToken tokenEntity = new RefreshToken();
        tokenEntity.setToken(refreshToken);
        tokenEntity.setUsuario(usuario);
        tokenEntity.setExpiryDate(new Date(System.currentTimeMillis() + 604800000)); 
        refreshTokenDao.save(tokenEntity);

        // 6. Retornar ambos tokens
        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);

        return tokens;
    }

    @Override
    public String register(RegisterDto registerDto) {
        // Buscar la persona asociada al ID proporcionado en RegisterDto
        Persona persona = personaRepository.findById(registerDto.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con el ID: " + registerDto.getIdPersona()));

        // Obtener el nombre de usuario usando la función generar_nombre_usuario
        String nombreUsuario = usuarioRepository.generarNombreUsuario(registerDto.getIdPersona());
        
        if (usuarioRepository.existsByUsername(registerDto.getUsername())) {
            throw new RuntimeException("El usuario ya existe");
        }

        // Crear y guardar usuario
        Usuario usuario = new Usuario();
        usuario.setUsername(nombreUsuario);  // Asignar el nombre de usuario generado
        usuario.setEmail(registerDto.getEmail());
        usuario.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        // Asociar la persona al usuario
        usuario.setPersona(persona);

        // Buscar el rol asignado al usuario
        Rol userRole = rolRepository.findByNombre(registerDto.getRoleName())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + registerDto.getRoleName()));

        // Crear la relación entre el usuario y el rol
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(userRole);

        usuario.setUsuarioRoles(Collections.singletonList(usuarioRol));

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);

        return "Usuario registrado con éxito con el rol: " + registerDto.getRoleName();
    }


    @Override
    public Usuario findUserByUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    @Transactional
    public void logout(String refreshToken) {
        refreshTokenDao.deleteByToken(refreshToken);
    }

    @Override
    public String refreshAccessToken(String refreshToken) {
        return jwtTokenProvider.refreshAccessToken(refreshToken);
    }

}
