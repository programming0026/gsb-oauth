package com.juniverse.proxy.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Envoltorio genérico de las respuestas correctas: {@code {"data": ...}}.
 * @param <T> tipo del dato
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private T data;
}
