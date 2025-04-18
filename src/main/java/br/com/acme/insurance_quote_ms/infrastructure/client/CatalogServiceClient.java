package br.com.acme.insurance_quote_ms.infrastructure.client;

import br.com.acme.insurance_quote_ms.domain.validation.CatalogValidationService;
import br.com.acme.insurance_quote_ms.infrastructure.client.dto.OfferResponseDTO;
import br.com.acme.insurance_quote_ms.infrastructure.client.dto.ProductResponseDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.CreateQuoteRequestDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CatalogServiceClient {

    private final Logger logger = LoggerFactory.getLogger(CatalogServiceClient.class);
    private final RestTemplate restTemplate;

    @Value("${catalog-service.url}")
    private String catalogServiceUrl;

    private final CatalogValidationService validationService;

    @Cacheable("products")
    public ProductResponseDTO getProduct(String productId) {
        String url = catalogServiceUrl + "/products/" + productId;

        try{
            ProductResponseDTO response = restTemplate.getForObject(url, ProductResponseDTO.class);
            if(response == null){
                logger.error("Produto não encontrado para ID: {}", productId);
                throw new IllegalArgumentException("Produto não encontrado para ID:" + productId);
            }
            return response;
        } catch(HttpClientErrorException e){
            logger.error("Erro ao buscar produto na url {}: {}", url, e.getMessage());
            throw new IllegalArgumentException("Erro ao buscar produto: " + e.getMessage());
        }
    }

    @Cacheable("offers")
    public OfferResponseDTO getOffer(String offerId) {
        String url = catalogServiceUrl + "/offers/" + offerId;
        try{
            OfferResponseDTO response = restTemplate.getForObject(url, OfferResponseDTO.class);

            if(response == null){
                logger.error("Oferta não encontrada para ID: {}", offerId);
                throw new IllegalArgumentException("Oferta não encontrada para ID:" + offerId);
            }
            return response;

        } catch(HttpClientErrorException e) {
            logger.error("Erro ao buscar oferta na url {}: {}", url, e.getMessage());
            throw new IllegalArgumentException("Erro ao buscar oferta: " + e.getMessage());
        }
    }

    public boolean validateQuoteRequest(CreateQuoteRequestDTO request) {
        ProductResponseDTO product = getProduct(request.productId());
        OfferResponseDTO offer = getOffer(request.offerId());

        if(product == null || offer == null) {
            throw new IllegalArgumentException("Produto ou oferta inválida.");
        }
        return validationService.validateQuoteRequest(product, offer, request);
    }
}
