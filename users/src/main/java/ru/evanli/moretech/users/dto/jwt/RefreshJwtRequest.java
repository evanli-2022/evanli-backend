package ru.evanli.moretech.users.dto.jwt;

import lombok.Data;

@Data
public class RefreshJwtRequest {
    public String refreshToken;
}
