package ru.evanli.moretech.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evanli.moretech.users.dto.jwt.JwtRequest;
import ru.evanli.moretech.users.dto.jwt.JwtResponse;
import ru.evanli.moretech.users.dto.jwt.RefreshJwtRequest;
import ru.evanli.moretech.users.service.AuthService;

import javax.security.auth.message.AuthException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest authRequest) throws Exception {
        return authService.authenticate(authRequest);
    }

    @PostMapping("/token")
    public JwtResponse getNewAccessToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        return authService.getAccessToken(request.getRefreshToken());
    }

    @PostMapping("/refresh")
    public JwtResponse getNewRefreshToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        return authService.refresh(request.getRefreshToken());
    }

}
