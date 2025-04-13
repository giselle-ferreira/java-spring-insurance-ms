package br.com.acme.insurance_quote_ms.interfaces.dto;

import java.math.BigDecimal;

public record CoverageDTO(
        String name,
        BigDecimal value
) {}
