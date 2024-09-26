package drivenPort.drivenJpa.authentication;

import entity.token.Token;
import entity.user.User;
import entity.userDetails.UserDetails;

import java.util.Date;
import java.util.Optional;

public interface JwtRepository {
    String extractUsername(String token);

    boolean isValid(String token, UserDetails user);

    boolean isTokenExpired(String token);

    Date extractExpiration(String token);

    String generateToken(User user);

    Token updateToken(Token token);

    Optional<Token> findByToken(String token);
}
