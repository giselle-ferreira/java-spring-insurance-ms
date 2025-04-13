package br.com.acme.insurance_quote_ms.interfaces.dto;

import br.com.acme.insurance_quote_ms.domain.model.Coverage;
import br.com.acme.insurance_quote_ms.domain.model.Customer;

import java.math.BigDecimal;
import java.util.List;

public record CreateQuoteRequest(
        String productId,
        String offerId,
        String category,
        BigDecimal totalMonthlyPremiumAmount,
        BigDecimal totalCoverageAmount,
        List<Coverage> coverages,
        List<String> assistances,
        Customer customer
) {}