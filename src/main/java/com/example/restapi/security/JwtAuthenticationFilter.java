package com.example.restapi.security;

import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.restapi.services.JwtService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@Order(1)
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService tokenProvider;

    public JwtAuthenticationFilter(JwtService tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(@SuppressWarnings("null") HttpServletRequest request,
            @SuppressWarnings("null") HttpServletResponse response, @SuppressWarnings("null") FilterChain filterChain)
            throws ServletException, IOException {
        String token = extractToken(request);

        if (token != null && isValidToken(token)) {
            UsernamePasswordAuthenticationToken authentication = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private boolean isValidToken(String token) {
        try {
            // Implementar validação
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        String username = tokenProvider.extractUsername(token);
        System.out.println(username);
        if (username != null) {
            return new UsernamePasswordAuthenticationToken(username, null, null);
        }
        return null;
    }
}
