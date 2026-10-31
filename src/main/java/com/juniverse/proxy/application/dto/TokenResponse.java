package com.juniverse.proxy.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** Token devuelto por el servidor OAuth. El token de acceso y el de refresco se excluyen de {@code toString()}. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class TokenResponse {

    @ToString.Exclude
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private Long expiresIn;

    @JsonProperty("ext_expires_in")
    private Long extExpiresIn;

    private String scope;

    @ToString.Exclude
    @JsonProperty("refresh_token")
    private String refreshToken;
}
