package ru.evanli.moretech.users.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evanli.moretech.users.domain.dto.UserDto;
import ru.evanli.moretech.users.service.UserService;

import java.util.List;

import static ru.evanli.moretech.users.config.OpenApiConfig.BEARER_TOKEN_SECURITY_SCHEME;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = BEARER_TOKEN_SECURITY_SCHEME)
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getById(id);
    }
}
