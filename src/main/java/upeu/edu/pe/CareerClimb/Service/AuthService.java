package upeu.edu.pe.CareerClimb.Service;

import upeu.edu.pe.CareerClimb.dto.LoginDto;
import upeu.edu.pe.CareerClimb.dto.RegisterDto;
import upeu.edu.pe.CareerClimb.Entity.Usuario;

import java.util.Map;

public interface AuthService {
    Map<String, String> login(LoginDto loginDto); // Devuelve Access Token y Refresh Token
    String register(RegisterDto registerDto); // Registro de usuario
    Usuario findUserByUsername(String username); // Buscar usuario por nombre de usuario
    String refreshAccessToken(String refreshToken); // Generar nuevo Access Token usando Refresh Token
    void logout(String refreshToken); // Cerrar sesión e invalidar Refresh Token
}
