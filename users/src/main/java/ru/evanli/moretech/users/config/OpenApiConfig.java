package ru.evanli.moretech.users.config;

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

    /*@Bean
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
    }*/

}
