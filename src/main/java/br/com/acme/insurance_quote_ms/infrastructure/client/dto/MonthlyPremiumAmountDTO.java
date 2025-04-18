package br.com.acme.insurance_quote_ms.infrastructure.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record MonthlyPremiumAmountDTO(
        BigDecimal maxAmount,
        BigDecimal minAmount,
        BigDecimal suggestedAmount
) {}
