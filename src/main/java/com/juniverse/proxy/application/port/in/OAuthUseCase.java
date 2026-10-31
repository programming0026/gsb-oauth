package com.juniverse.proxy.application.port.in;

import com.juniverse.proxy.application.dto.Response;
import com.juniverse.proxy.application.dto.TokenRequest;
import com.juniverse.proxy.application.dto.TokenResponse;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

/** Puerto de entrada: casos de uso de OAuth. */
public interface OAuthUseCase {

    /**
     * Obtiene un token de acceso.
     * @param request credenciales y parámetros validados
     * @return el token dentro del envoltorio {@code Response}
     */
    Mono<Response<TokenResponse>> getAccessToken(@Valid TokenRequest request);
}
