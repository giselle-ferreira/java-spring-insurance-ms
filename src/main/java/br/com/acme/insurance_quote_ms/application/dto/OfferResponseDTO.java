package br.com.acme.insurance_quote_ms.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record OfferResponseDTO(
        String id,
        String productId,
        String name,
        LocalDateTime createdAt,
        Map<String, BigDecimal> coverages,
        List<String> assistances,
        MonthlyPremiumAmountDTO monthlyPremiumAmount
) {}
