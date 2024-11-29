package upeu.edu.pe.CareerClimb.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.CareerClimb.Dao.RefreshTokenDao;
import upeu.edu.pe.CareerClimb.Entity.RefreshToken;
import upeu.edu.pe.CareerClimb.Repository.RefreshTokenRepository;
import java.util.Optional;

@Component
public class RefreshTokenDaoImpl implements RefreshTokenDao {

	@Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    public void deleteByToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }

    @Override
    public void deleteByUsuarioId(Long userId) {
        refreshTokenRepository.deleteByUsuario_IdUsuario(userId);
    }

    @Override
    public RefreshToken save(RefreshToken refreshToken) {
        return refreshTokenRepository.save(refreshToken);
    }
}
