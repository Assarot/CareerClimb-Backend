package upeu.edu.pe.CareerClimb.Dao;

import upeu.edu.pe.CareerClimb.Entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenDao {
    Optional<RefreshToken> findByToken(String token);
    void deleteByToken(String token);
    void deleteByUsuarioId(Long userId);
    RefreshToken save(RefreshToken refreshToken);
}
