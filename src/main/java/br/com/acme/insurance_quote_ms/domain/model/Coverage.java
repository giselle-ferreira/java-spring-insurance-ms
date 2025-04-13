package br.com.acme.insurance_quote_ms.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class Coverage {

    private String name;
    private BigDecimal value;
}
