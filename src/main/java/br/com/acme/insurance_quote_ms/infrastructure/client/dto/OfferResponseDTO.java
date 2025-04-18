package br.com.acme.insurance_quote_ms.infrastructure.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Builder
public record OfferResponseDTO(

        String id,
        String productId,
        String name,
        LocalDateTime createdAt,
        boolean active,
        Map<String, BigDecimal> coverages,
        List<String> assistances,
        MonthlyPremiumAmountDTO monthlyPremiumAmount
) {}
