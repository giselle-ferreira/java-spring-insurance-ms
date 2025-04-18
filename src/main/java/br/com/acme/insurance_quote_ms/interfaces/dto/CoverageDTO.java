package br.com.acme.insurance_quote_ms.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CoverageDTO(
        String name,
        BigDecimal value
) {}
