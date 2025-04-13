package br.com.acme.insurance_quote_ms.interfaces.dto;

import java.time.LocalDateTime;

public record PolicyCreatedMessageDTO(
        Long id,
        String policyId,
        LocalDateTime policyIssuedAt
) {}
