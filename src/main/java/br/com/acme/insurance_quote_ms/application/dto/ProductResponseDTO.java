package br.com.acme.insurance_quote_ms.application.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ProductResponseDTO(
        String id,
        String name,
        LocalDateTime createdAt,
        boolean active,
        List<String> offers
) {
}
