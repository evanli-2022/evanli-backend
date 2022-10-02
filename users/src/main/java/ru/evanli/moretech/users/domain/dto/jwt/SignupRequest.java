package ru.evanli.moretech.users.domain.dto.jwt;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String fullName;
    private String position;
    private String password;
}
