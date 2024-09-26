package com.seek.candidate_service.repositories.token;

import com.seek.candidate_service.entity.TokenEntity;
import com.seek.candidate_service.exceptions.TokenNotFoundException;
import drivenPort.drivenJpa.authentication.JwtRepository;
import entity.token.Token;
import entity.user.User;
import entity.userDetails.UserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Component
public class JwtRepositoryImpl implements JwtRepository {

    private final String SECRET_KEY = "4bb6d1dfbafb64a681139d1586b6f1160d18159afd57c8c79136d7490630407c";
    private final JpaTokenRepository tokenRepository;

    public JwtRepositoryImpl(JpaTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public boolean isValid(String token, UserDetails user) {
        String username = extractUsername(token);

        boolean validToken = tokenRepository
                .findByToken(token)
                .map(t -> !t.isLoggedOut())
                .orElse(false);

        return (username.equals(user.getUsername())) && !isTokenExpired(token) && validToken;
    }

    @Override
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    @Override
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    @Override
    public String generateToken(User user) {
        String token = Jwts
                .builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .signWith(getSigninKey())
                .compact();

        return token;
    }

    @Override
    public Token updateToken(Token token) {
        TokenEntity tokenEntity = tokenRepository.findById(token.getUuid().toString())
                .orElseThrow(TokenNotFoundException::new);
        tokenEntity.setLoggedOut(token.isLoggedOut());
        tokenRepository.save(tokenEntity);
        return Token.builder()
                .uuid(UUID.fromString(tokenEntity.getUuid()))
                .token(tokenEntity.getToken())
                .loggedOut(token.isLoggedOut())
                .user(User.builder().username(token.getUser().getUsername()).build())
                .build();
    }

    @Override
    public Optional<Token> findByToken(String token) {
        return tokenRepository.findByToken(token)
                .map(tokenEntity -> Token.builder()
                        .uuid(UUID.fromString(tokenEntity.getUuid()))
                        .loggedOut(tokenEntity.isLoggedOut())
                        .token(tokenEntity.getToken())
                        .user(User.builder().username(tokenEntity.getUser().getUsername()).build())
                        .build());
    }

    private SecretKey getSigninKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
