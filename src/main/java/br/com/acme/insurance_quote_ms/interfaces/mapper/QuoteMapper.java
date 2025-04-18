package br.com.acme.insurance_quote_ms.interfaces.mapper;

import br.com.acme.insurance_quote_ms.domain.entity.CustomerEntity;
import br.com.acme.insurance_quote_ms.domain.entity.QuoteEntity;
import br.com.acme.insurance_quote_ms.interfaces.dto.CreateQuoteRequestDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.CustomerDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.QuoteResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuoteMapper {

    QuoteEntity mapToEntity(CreateQuoteRequestDTO createQuoteRequest);
    QuoteResponseDTO mapToQuoteResponseDTO(QuoteEntity quoteEntity);

    CustomerEntity mapToCustomerEntity(CustomerDTO customerDTO);
    CustomerDTO mapToCustomerDTO(CustomerEntity customerEntity);
}
