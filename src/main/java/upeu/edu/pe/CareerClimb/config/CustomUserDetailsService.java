package upeu.edu.pe.CareerClimb.config;

import upeu.edu.pe.CareerClimb.Entity.Usuario;
import upeu.edu.pe.CareerClimb.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	Usuario user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

    	Set<GrantedAuthority> authorities = user.getUsuarioRoles().stream()
    		    .map(usuarioRol -> new SimpleGrantedAuthority("ROLE_" + usuarioRol.getRol().getNombre())) // Usa getRol().getNombre() para obtener el nombre del rol
    		    .collect(Collectors.toSet());

    		return new org.springframework.security.core.userdetails.User(
    		    username,
    		    user.getPassword(),
    		    authorities
    		);

    }
}
