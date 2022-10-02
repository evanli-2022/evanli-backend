package ru.evanli.moretech.users.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String BEARER_TOKEN_SECURITY_SCHEME = "JWT Token";

    @Bean
    public OpenAPI openApiConfiguration() {
        return new OpenAPI()
            .addSecurityItem(
                new SecurityRequirement()
                    .addList(BEARER_TOKEN_SECURITY_SCHEME)
            )
            .components(
                new Components()
                    .addSecuritySchemes(BEARER_TOKEN_SECURITY_SCHEME,
                        new SecurityScheme()
                            .name(BEARER_TOKEN_SECURITY_SCHEME)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                    )
            )
            .info(new Info()
                .title("Сервис пользователей и аутентификации")
                .version("1.0")
            )
            ;
    }

}
