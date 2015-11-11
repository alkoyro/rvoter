package com.lc.rv.rest.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: alkoyro
 */
public class StatelessAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";

    private TokenHandler tokenHandler;

    public StatelessAuthenticationSuccessHandler(TokenHandler tokenHandler) {
        this.tokenHandler = tokenHandler;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String token = tokenHandler.generateToken(authentication);
        response.addHeader(AUTH_HEADER_NAME, token);
    }
}
