package br.com.acme.insurance_quote_ms.infrastructure.client;

import br.com.acme.insurance_quote_ms.domain.validation.CatalogValidationService;
import br.com.acme.insurance_quote_ms.infrastructure.client.dto.OfferResponseDTO;
import br.com.acme.insurance_quote_ms.infrastructure.client.dto.ProductResponseDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.CreateQuoteRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CatalogServiceClient {

    private final RestTemplate restTemplate;

    @Value("${catalog-service.url}")
    private final String catalogServiceUrl;

    private final CatalogValidationService validationService;

    @Cacheable("products")
    public ProductResponseDTO getProduct(String productId) {
        String url = catalogServiceUrl + "/products/" + productId;
        return restTemplate.getForObject(url, ProductResponseDTO.class);
    }

    @Cacheable("offers")
    public OfferResponseDTO getOffer(String offerId) {
        String url = catalogServiceUrl + "/offers/" + offerId;
        return restTemplate.getForObject(url, OfferResponseDTO.class);
    }

    public boolean validateQuoteRequest(CreateQuoteRequestDTO request) {
        ProductResponseDTO product = getProduct(request.productId());
        OfferResponseDTO offer = getOffer(request.offerId());
        return validationService.validateQuoteRequest(product, offer, request);
    }
}
