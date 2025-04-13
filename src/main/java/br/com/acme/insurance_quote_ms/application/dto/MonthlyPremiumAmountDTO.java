package br.com.acme.insurance_quote_ms.application.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record MonthlyPremiumAmountDTO(
        BigDecimal maxAmount,
        BigDecimal minAmount,
        BigDecimal suggestedAmount
) {}
