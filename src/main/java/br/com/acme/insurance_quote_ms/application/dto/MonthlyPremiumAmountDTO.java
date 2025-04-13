package br.com.acme.insurance_quote_ms.application.dto;

import java.math.BigDecimal;

public record MonthlyPremiumAmountDTO(
        BigDecimal maxAmount,
        BigDecimal minAmount,
        BigDecimal suggestedAmount
) {
}
