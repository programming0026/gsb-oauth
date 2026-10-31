package com.juniverse.proxy.infrastructure.adapter.in.rest;

import com.juniverse.proxy.application.dto.Error;
import com.juniverse.proxy.domain.exception.ServiceException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.stream.Collectors;

/** Convierte las excepciones en respuestas JSON {@link Error}. */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /** 400: faltan campos obligatorios. */
    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ResponseEntity<Error>> handleConstraintViolation(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        log.warn("Validation failed: {}", message);
        Error errorResponse = Error.builder()
                .error(message)
                .status(400)
                .timestamp(Instant.now())
                .build();
        return Mono.just(ResponseEntity.badRequest().body(errorResponse));
    }

    /** El código del error del servidor OAuth (401, 503...). */
    @ExceptionHandler(ServiceException.class)
    public Mono<ResponseEntity<Error>> handleServiceException(ServiceException ex) {
        log.error("Service exception occurred: {} - Status: {}", ex.getMessage(), ex.getStatusCode());

        Error errorResponse = Error.builder()
                .error(ex.getMessage())
                .status(ex.getStatusCode().value())
                .timestamp(Instant.now())
                .build();
        return Mono.just(ResponseEntity
                .status(ex.getStatusCode())
                .body(errorResponse));
    }


    /** 400: la petición está mal formada. */
    @ExceptionHandler(ServerWebInputException.class)
    public Mono<ResponseEntity<Error>> handleBadInput(ServerWebInputException ex) {
        log.warn("Invalid request: {}", ex.getReason());
        Error errorResponse = Error.builder()
                .error("Invalid request")
                .status(400)
                .timestamp(Instant.now())
                .build();
        return Mono.just(ResponseEntity.badRequest().body(errorResponse));
    }

    /** 500: error inesperado (sin exponer el detalle). */
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<Error>> handleGenericException(Exception ex) {
        log.error("Unexpected exception occurred: {}", ex.getMessage(), ex);

        Error errorResponse = Error.builder()
                .error("An unexpected error occurred")
                .status(500)
                .timestamp(Instant.now())
                .build();
        return Mono.just(ResponseEntity
                .internalServerError()
                .body(errorResponse));
    }
}
