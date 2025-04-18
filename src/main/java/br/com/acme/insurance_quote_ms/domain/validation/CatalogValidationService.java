package br.com.acme.insurance_quote_ms.domain.validation;

import br.com.acme.insurance_quote_ms.infrastructure.client.dto.OfferResponseDTO;
import br.com.acme.insurance_quote_ms.infrastructure.client.dto.ProductResponseDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.CreateQuoteRequestDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Component
public class CatalogValidationService {

    public boolean validateQuoteRequest(ProductResponseDTO product, OfferResponseDTO offer, CreateQuoteRequestDTO request) {
        return validateProductAndOffer(product, offer, request.productId(), request.offerId())
                && validateCoverages(offer, request.coverages())
                && validateAssistances(offer, request.assistances())
                && validateMonthlyPremium(offer, request.totalMonthlyPremiumAmount())
                && validateTotalCoverageValue(request.coverages(), request.totalCoverageAmount());
    }

    private boolean validateProductAndOffer(ProductResponseDTO product, OfferResponseDTO offer, String productId, String offerId) {
        if (product == null || !product.active() || !product.offers().contains(offerId)) {
            return false;
        }
        return offer != null && offer.active() && offer.productId().equals(productId);
    }

    private boolean validateCoverages(OfferResponseDTO offer, Map<String, BigDecimal> requestCoverages) {
        Map<String, BigDecimal> offerCoverages = offer.coverages();

        for (Map.Entry<String, BigDecimal> entry : requestCoverages.entrySet()){
            String coverageName = entry.getKey();
            BigDecimal coverageValue = entry.getValue();

            if (!offerCoverages.containsKey(coverageName)) {
                return false;
            }
            if(coverageValue.compareTo(offerCoverages.get(coverageName)) > 0){
                return false;
            }
        }
        return true;
    }

    private boolean validateAssistances(OfferResponseDTO offer, List<String> requestAssistances) {
        return new HashSet<>(offer.assistances()).containsAll(requestAssistances);
    }

    private boolean validateMonthlyPremium(OfferResponseDTO offer, BigDecimal monthlyPremium) {
        BigDecimal minAmount = offer.monthlyPremiumAmount().minAmount();
        BigDecimal maxAmount = offer.monthlyPremiumAmount().maxAmount();
        return monthlyPremium.compareTo(minAmount) >= 0 && monthlyPremium.compareTo(maxAmount) <= 0;
    }

    private boolean validateTotalCoverageValue(Map<String, BigDecimal> coverages, BigDecimal totalCoverageAmount) {
        BigDecimal sum = coverages.values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.compareTo(totalCoverageAmount) == 0;
    }
}
