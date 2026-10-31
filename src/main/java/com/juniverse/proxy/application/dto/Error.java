package com.juniverse.proxy.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

/** Cuerpo de las respuestas de error: mensaje, código HTTP y momento del error. */
@Getter
@Builder
public class Error {
    private String error;
    private int status;
    private Instant timestamp;
}
