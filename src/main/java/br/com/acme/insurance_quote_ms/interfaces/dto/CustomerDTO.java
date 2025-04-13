package br.com.acme.insurance_quote_ms.interfaces.dto;

public record CustomerDTO(
        String documentNumber,
        String name,
        String type,
        String gender,
        String dateOfBirth,
        String email,
        Long phoneNumber
) {}