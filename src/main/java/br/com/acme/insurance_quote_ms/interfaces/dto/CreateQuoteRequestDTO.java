package br.com.acme.insurance_quote_ms.interfaces.dto;

import br.com.acme.insurance_quote_ms.domain.model.Coverage;
import br.com.acme.insurance_quote_ms.domain.model.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Builder
public record CreateQuoteRequestDTO (
        String productId,
        String offerId,
        String category,
        BigDecimal totalMonthlyPremiumAmount,
        BigDecimal totalCoverageAmount,
        Map<String, BigDecimal> coverages,
        List<String> assistances,
        CustomerDTO customer
) {}