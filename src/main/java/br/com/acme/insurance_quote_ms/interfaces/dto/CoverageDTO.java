package br.com.acme.insurance_quote_ms.interfaces.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CoverageDTO(
        String name,
        BigDecimal value
) {}
