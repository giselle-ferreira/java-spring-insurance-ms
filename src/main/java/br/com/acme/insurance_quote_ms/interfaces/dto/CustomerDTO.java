package br.com.acme.insurance_quote_ms.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CustomerDTO(
        String documentNumber,
        String name,
        String type,
        String gender,
        String dateOfBirth,
        String email,
        Long phoneNumber
) {}