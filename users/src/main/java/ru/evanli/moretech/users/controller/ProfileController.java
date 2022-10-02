package ru.evanli.moretech.users.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evanli.moretech.users.domain.dto.ProfileDto;
import ru.evanli.moretech.users.domain.dto.UserDto;
import ru.evanli.moretech.users.service.AuthService;

import static ru.evanli.moretech.users.config.OpenApiConfig.BEARER_TOKEN_SECURITY_SCHEME;

@RestController
@RequestMapping("/api/profile")
@SecurityRequirement(name = BEARER_TOKEN_SECURITY_SCHEME)
@RequiredArgsConstructor
public class ProfileController {

    private final AuthService authService;

    @GetMapping
    public ProfileDto getProfile() {
        return authService.getCurrentProfile();
    }
}
