package com.juniverse.proxy.domain.port.out;

import com.juniverse.proxy.application.dto.TokenRequest;
import com.juniverse.proxy.application.dto.TokenResponse;
import reactor.core.publisher.Mono;

/** Puerto de salida: comunicación con el servidor OAuth. */
public interface OAuthPort {

    /**
     * Pide un token al servidor OAuth.
     * @param request credenciales y parámetros
     * @return el token
     */
    Mono<TokenResponse> requestToken(TokenRequest request);
}
