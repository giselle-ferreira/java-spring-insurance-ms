package br.com.acme.insurance_quote_ms.interfaces.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PolicyCreatedMessageDTO(
        Long id,
        String policyId,
        LocalDateTime policyIssuedAt
) {}
