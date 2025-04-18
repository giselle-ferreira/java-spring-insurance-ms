package br.com.acme.insurance_quote_ms.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PolicyCreatedMessageDTO(
        Long id,
        String policyId,
        LocalDateTime policyIssuedAt
) {}
