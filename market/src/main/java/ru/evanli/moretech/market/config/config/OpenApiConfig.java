package ru.evanli.moretech.market.config.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
    name = OpenApiConfig.BEARER_TOKEN_SECURITY_SCHEME,
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)
public class OpenApiConfig {

    public static final String BEARER_TOKEN_SECURITY_SCHEME = "JWT Token Authentication";

}
