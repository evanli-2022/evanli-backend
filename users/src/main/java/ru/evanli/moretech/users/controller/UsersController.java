package ru.evanli.moretech.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evanli.moretech.users.dto.UserDto;
import ru.evanli.moretech.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getAll();
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getById(id);
    }
}
