package ru.evanli.moretech.users.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public static final String BEARER_TOKEN_SECURITY_SCHEME = "JWT Token Authentication";

    @Bean
    public OpenAPI openApiConfiguration(@Value("${custom.swagger.server-url:http://localhost:8001}") String serverUrl) {
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
            .addServersItem(new Server().url(serverUrl))
            .info(new Info()
                .title("Сервис пользователей и авторизации")
                .version("1.0")
            );
    }
}
