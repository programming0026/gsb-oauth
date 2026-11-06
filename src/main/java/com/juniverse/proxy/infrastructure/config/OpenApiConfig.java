package com.juniverse.proxy.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Información general de la documentación OpenAPI. */
@Configuration
public class OpenApiConfig {

    /** Título, versión, contacto y licencia de la API. */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API del proxy de OAuth")
                        .version("1.0.0")
                        .description("API que consume servicios OAuth2")
                        .contact(new Contact()
                                .name("Java Universe")
                                .url("https://github.com/programming0026"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
