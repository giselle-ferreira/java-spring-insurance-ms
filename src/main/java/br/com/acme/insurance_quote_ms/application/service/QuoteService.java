package br.com.acme.insurance_quote_ms.application.service;

import br.com.acme.insurance_quote_ms.infrastructure.client.CatalogServiceClient;
import br.com.acme.insurance_quote_ms.infrastructure.repository.QuoteRepository;
import br.com.acme.insurance_quote_ms.interfaces.dto.CreateQuoteRequest;
import br.com.acme.insurance_quote_ms.interfaces.dto.QuoteResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;
    private final CatalogServiceClient catalogServiceClient;

    public QuoteService(QuoteRepository quoteRepository, CatalogServiceClient catalogServiceClient) {
        this.quoteRepository = quoteRepository;
        this.catalogServiceClient = catalogServiceClient;
    }

    public QuoteResponseDTO createQuote(CreateQuoteRequest request){

        return null;
    }

    public QuoteResponseDTO consultQuoteById(Long id){

        return null;
    }

    public void updateQuoteWithPolicy(
            Long id, String policyId, LocalDateTime policyIssuedAt
    ) {

    }
}
