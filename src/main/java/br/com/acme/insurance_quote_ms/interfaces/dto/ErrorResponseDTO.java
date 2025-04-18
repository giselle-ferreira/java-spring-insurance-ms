package br.com.acme.insurance_quote_ms.interfaces.dto;

import lombok.Builder;

@Builder
public record ErrorResponseDTO(
        int status,
        String message) {
}
