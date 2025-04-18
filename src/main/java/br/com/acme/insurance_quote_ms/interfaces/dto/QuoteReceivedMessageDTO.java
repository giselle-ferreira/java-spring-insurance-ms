package br.com.acme.insurance_quote_ms.interfaces.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Builder
public record QuoteReceivedMessageDTO(
        Long id,
        String productId,
        String offerId,
        String category,
        BigDecimal totalMonthlyPremiumAmount,
        BigDecimal totalCoverageAmount,
        Map<String, BigDecimal> coverages,
        List<String> assistances,
        CustomerDTO customer
) {}
