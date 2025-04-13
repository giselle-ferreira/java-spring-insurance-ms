package br.com.acme.insurance_quote_ms.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class Customer {

    private String documentNumber;
    private String name;
    private String type;
    private String gender;
    private String dateOfBirth;
    private String email;
    private Long phoneNumber;
}
