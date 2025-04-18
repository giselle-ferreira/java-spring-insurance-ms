package br.com.acme.insurance_quote_ms.infrastructure.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ProductResponseDTO(
        String id,
        String name,
        LocalDateTime createdAt,
        boolean active,
        List<String> offers
) {}
