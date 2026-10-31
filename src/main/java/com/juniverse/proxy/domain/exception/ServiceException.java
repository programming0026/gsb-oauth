package com.juniverse.proxy.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

/** Error al hablar con el servidor OAuth; lleva el código HTTP con el que se responde al cliente. */
@Getter
public class ServiceException extends RuntimeException {

    private final HttpStatusCode statusCode;

    /**
     * Crea la excepción.
     * @param statusCode código HTTP
     * @param message descripción del error
     */
    public ServiceException(HttpStatusCode statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    /**
     * Crea la excepción a partir de un código numérico.
     * @param statusCode código HTTP (por ejemplo 401)
     * @param message descripción del error
     */
    public ServiceException(int statusCode, String message) {
        super(message);
        this.statusCode = HttpStatusCode.valueOf(statusCode);
    }

    /**
     * Crea la excepción con su causa.
     * @param statusCode código HTTP
     * @param message descripción del error
     * @param cause causa original
     */
    public ServiceException(HttpStatusCode statusCode, String message, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }
}
