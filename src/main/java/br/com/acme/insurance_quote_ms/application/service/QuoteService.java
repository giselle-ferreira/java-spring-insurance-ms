package br.com.acme.insurance_quote_ms.application.service;

import br.com.acme.insurance_quote_ms.domain.entity.QuoteEntity;
import br.com.acme.insurance_quote_ms.infrastructure.client.CatalogServiceClient;
import br.com.acme.insurance_quote_ms.infrastructure.messaging.RabbitMQProducer;
import br.com.acme.insurance_quote_ms.infrastructure.repository.QuoteRepository;
import br.com.acme.insurance_quote_ms.interfaces.dto.CreateQuoteRequestDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.QuoteReceivedMessageDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.QuoteResponseDTO;
import br.com.acme.insurance_quote_ms.interfaces.mapper.QuoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;
    private final CatalogServiceClient catalogServiceClient;
    private final QuoteMapper quoteMapper;
    private final RabbitMQProducer rabbitMQProducer;

    public QuoteResponseDTO createQuote(CreateQuoteRequestDTO request){

        if(!catalogServiceClient.validateQuoteRequest(request)) {
            throw new IllegalArgumentException("Invalid Quote request");
        }

        QuoteEntity quoteEntity = quoteMapper.mapToEntity(request);
        QuoteEntity savedEntity = quoteRepository.save(quoteEntity);

        // Envia para fila insurance-quote-received
        QuoteReceivedMessageDTO message = QuoteReceivedMessageDTO.builder()
                .id(savedEntity.getId())
                .build();
        rabbitMQProducer.sendQuoteReceivedMessage(message);

        return quoteMapper.mapToQuoteResponseDTO(savedEntity);
    }

    public QuoteResponseDTO consultQuoteById(Long id){
        Optional<QuoteEntity> quoteEntityOptional = quoteRepository.findById(id);

        if(quoteEntityOptional.isEmpty()){
            throw new IllegalArgumentException("Quote not found for ID: " + id );
        }

        QuoteEntity quoteEntity = quoteEntityOptional.get();
        return quoteMapper.mapToQuoteResponseDTO(quoteEntity);
    }

    public void updateQuoteWithPolicy(Long id, String policyId, LocalDateTime policyIssuedAt) {
        Optional<QuoteEntity> quoteEntityOptional = quoteRepository.findById(id);

        if(quoteEntityOptional.isEmpty()){
            throw new IllegalArgumentException("Quote not found for ID: " + id );
        }

        QuoteEntity quoteEntity = quoteEntityOptional.get();
        quoteEntity.setPolicyId(policyId);
        quoteEntity.setPolicyIssuedAt(policyIssuedAt);

        quoteRepository.save(quoteEntity);
    }
}
