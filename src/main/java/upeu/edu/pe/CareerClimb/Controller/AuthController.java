package upeu.edu.pe.CareerClimb.Controller;

import upeu.edu.pe.CareerClimb.dto.LoginDto;
import upeu.edu.pe.CareerClimb.dto.RegisterDto;
import upeu.edu.pe.CareerClimb.Service.AuthService;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            // Generar Access Token y Refresh Token
            Map<String, String> tokens = authService.login(loginDto);

            return ResponseEntity.ok(tokens);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    // Endpoint para registrar un usuario
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        try {
            String result = authService.register(registerDto);

            Map<String, String> response = new HashMap<>();
            response.put("message", result);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Endpoint para refrescar el Access Token
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody Map<String, String> request) {
        try {
            String refreshToken = request.get("refreshToken");
            String newAccessToken = authService.refreshAccessToken(refreshToken);

            // Retornar el nuevo Access Token
            Map<String, String> response = new HashMap<>();
            response.put("accessToken", newAccessToken);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


    // Endpoint para logout
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody Map<String, String> request) {
        try {
            String refreshToken = request.get("refreshToken");
            authService.logout(refreshToken);

            // Respuesta exitosa en formato JSON
            Map<String, String> response = new HashMap<>();
            response.put("message", "Sesión cerrada con éxito");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            // Respuesta en caso de error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
