package ru.evanli.moretech.users.utils;

import io.jsonwebtoken.Claims;
import ru.evanli.moretech.users.domain.JwtAuthentication;
import ru.evanli.moretech.users.domain.Role;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setRoles(getRoles(claims));
        jwtInfoToken.setFirstName(claims.get("firstName", String.class));
        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }

    private static Set<Role> getRoles(Claims claims) {
        final List<String> roles = claims.get("roles", List.class);
        return roles.stream()
            .map(Role::valueOf)
            .collect(Collectors.toSet());
    }

}