package com.vehicle.microservice_gateaway.security.jwt;

import com.vehicle.microservice_gateaway.security.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface IJwtProvider {
    String generateToken(UserPrincipal authentication);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
