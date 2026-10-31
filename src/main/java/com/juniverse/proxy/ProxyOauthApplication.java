package com.juniverse.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/** Proxy de OAuth2: recibe las credenciales del frontend, pide el token al servidor OAuth (por ejemplo Keycloak) y devuelve la respuesta ya adaptada. */
@SpringBootApplication
@ConfigurationPropertiesScan
public class ProxyOauthApplication {

	/**
	 * Arranca la aplicación.
	 * @param args argumentos de la línea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProxyOauthApplication.class, args);
	}


}
