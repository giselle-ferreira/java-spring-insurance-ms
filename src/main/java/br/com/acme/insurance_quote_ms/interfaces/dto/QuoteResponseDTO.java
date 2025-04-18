package br.com.acme.insurance_quote_ms.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Builder
public record QuoteResponseDTO(
        Long id,
        String productId,
        String offerId,
        String category,
        BigDecimal totalMonthlyPremiumAmount,
        BigDecimal totalCoverageAmount,
        Map<String, BigDecimal> coverages,
        List<String> assistances,
        CustomerDTO customer,
        String policyId,
        LocalDateTime policyIssuedAt
) {}
