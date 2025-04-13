package br.com.acme.insurance_quote_ms.interfaces.dto;

import lombok.Builder;

@Builder
public record QuoteReceivedMessageDTO(
        Long id
) {}
