package com.juniverse.proxy.infrastructure.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** Propiedades {@code oauth.client.*}: URL del servidor, número de intentos y tiempo máximo. */
@Data
@Component
@ConfigurationProperties(prefix = "oauth.client")
public class OAuthProperties {

    private String url;

    private Integer attempts = 3;

    private Long timeout = 15000L;

}
