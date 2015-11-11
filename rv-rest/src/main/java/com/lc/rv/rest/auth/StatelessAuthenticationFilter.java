package com.lc.rv.rest.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Alexey.Koyro
 */
public class StatelessAuthenticationFilter extends GenericFilterBean {

    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
    private TokenHandler tokenHandler;

    public StatelessAuthenticationFilter(TokenHandler tokenHandler) {
        this.tokenHandler = tokenHandler;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        final String token = httpRequest.getHeader(AUTH_HEADER_NAME);
        if (token == null) {
            chain.doFilter(request, response);

            return;
        }


        final User user = tokenHandler.getUserFromToken(token);
        if (user != null) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken
                    (user.getUsername(), user.getPassword(), user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
}
