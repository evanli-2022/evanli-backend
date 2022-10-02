package ru.evanli.moretech.users.domain.dto.jwt;

import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {
    private String username;
    private String position;
    private Set<String> roles;
    private String password;
}
