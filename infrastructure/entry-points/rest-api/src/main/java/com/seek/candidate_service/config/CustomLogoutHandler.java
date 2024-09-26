package com.seek.candidate_service.config;

import com.seek.candidate_service.use_case.token.FindByTokenUseCase;
import com.seek.candidate_service.use_case.token.UpdateTokenUseCase;
import entity.token.Token;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
public class CustomLogoutHandler implements LogoutHandler {

    private final FindByTokenUseCase findByTokenUseCase;
    private final UpdateTokenUseCase updateTokenUseCase;

    public CustomLogoutHandler(FindByTokenUseCase findByTokenUseCase, UpdateTokenUseCase updateTokenUseCase) {
        this.findByTokenUseCase = findByTokenUseCase;
        this.updateTokenUseCase = updateTokenUseCase;
    }

    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        String token = authHeader.substring(7);
        Token storedToken = findByTokenUseCase.findByToken(token).orElse(null);

        if (storedToken != null) {
            storedToken.setLoggedOut(true);
            updateTokenUseCase.updateToken(storedToken);
        }
    }
}
