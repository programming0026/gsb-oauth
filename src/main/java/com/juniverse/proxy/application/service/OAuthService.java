package com.juniverse.proxy.application.service;

import com.juniverse.proxy.application.dto.Response;
import com.juniverse.proxy.application.dto.TokenRequest;
import com.juniverse.proxy.application.dto.TokenResponse;
import com.juniverse.proxy.application.port.in.OAuthUseCase;
import com.juniverse.proxy.domain.port.out.OAuthPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

/** Servicio de aplicación: valida la petición y delega en el puerto de salida. */
@Slf4j
@Service
@RequiredArgsConstructor
@Validated
public class OAuthService implements OAuthUseCase {

    private final OAuthPort oAuthPort;

    /**
     * Valida la petición y pide el token al servidor OAuth.
     * @param request credenciales y parámetros
     * @return el token dentro del envoltorio {@code Response}
     * @throws jakarta.validation.ConstraintViolationException si falta algún campo obligatorio
     */
    @Override
    public Mono<Response<TokenResponse>> getAccessToken(@Valid TokenRequest request) {
        log.info("Request: {}", request);
        return oAuthPort.requestToken(request).map(Response::new);
    }

}
