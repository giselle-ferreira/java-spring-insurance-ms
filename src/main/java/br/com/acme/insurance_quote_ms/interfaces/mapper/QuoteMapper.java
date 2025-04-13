package br.com.acme.insurance_quote_ms.interfaces.mapper;

import br.com.acme.insurance_quote_ms.domain.entity.QuoteEntity;
import br.com.acme.insurance_quote_ms.domain.model.Coverage;
import br.com.acme.insurance_quote_ms.domain.model.Customer;
import br.com.acme.insurance_quote_ms.interfaces.dto.CoverageDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.CreateQuoteRequest;
import br.com.acme.insurance_quote_ms.interfaces.dto.CustomerDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.QuoteResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuoteMapper {

    QuoteEntity mapToEntity(CreateQuoteRequest createQuoteRequest);
    QuoteResponseDTO mapToQuoteResponseDTO(QuoteEntity quoteEntity);

    Coverage mapToCoverage(CoverageDTO coverageDTO);
    CoverageDTO mapToCoverageDTO(Coverage coverage);

    Customer mapToCustomer(CustomerDTO customerDTO);
    CustomerDTO mapToCustomerDTO(Customer customer);
}
