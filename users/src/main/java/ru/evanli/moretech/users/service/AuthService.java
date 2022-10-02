package ru.evanli.moretech.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.evanli.moretech.users.domain.UserDetailsImpl;
import ru.evanli.moretech.users.domain.dto.ProfileDto;
import ru.evanli.moretech.users.utils.JwtUtils;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Value("${jwt.expirationMs}")
    private final  int jwtExpirationMs;
    @Value("${jwt.secret}")
    private final String jwtSecret;

    public boolean validateJwtToken(String authToken) {
        return JwtUtils.validateJwtToken(authToken, jwtSecret);
    }

    public String getUserNameFromJwtToken(String token) {
        return JwtUtils.getUserNameFromJwtToken(token, jwtSecret);
    }

    public String generateJwtToken(Authentication authentication) {
        return JwtUtils.generateJwtToken(authentication, jwtSecret, jwtExpirationMs);
    }

    public ProfileDto getCurrentProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ProfileDto.builder()
            .id(userDetails.getId())
            .username(userDetails.getUsername())
            .fullName(userDetails.getFullName())
            .position(userDetails.getPosition())
            .createdAt(userDetails.getCreatedAt())
            .roles(userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
            .build();

    }
}
