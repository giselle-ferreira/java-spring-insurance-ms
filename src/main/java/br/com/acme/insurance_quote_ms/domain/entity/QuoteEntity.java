package br.com.acme.insurance_quote_ms.domain.entity;

import br.com.acme.insurance_quote_ms.domain.model.Coverage;
import br.com.acme.insurance_quote_ms.domain.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "quotes")
public class QuoteEntity {

    @Column(name = "product_id")
    private String productId;

    @Column(name = "offer_id")
    private String offerId;

    @Column(name = "category")
    private String category;

    @Column(name = "total_monthly_premium_amount")
    private BigDecimal totalMonthlyPremiumAmount;

    @Column(name = "total_coverage_amount")
    private BigDecimal totalCoverageAmount;

    @ElementCollection
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "coverage_name")),
            @AttributeOverride(name = "value", column = @Column(name = "coverage_value"))
    })
    private List<Coverage> coverages;

    @ElementCollection
    private List<String> assistances;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "documentNumber", column = @Column(name = "customer_document_number")),
            @AttributeOverride(name = "name", column = @Column(name = "customer_name")),
            @AttributeOverride(name = "type", column = @Column(name = "customer_type")),
            @AttributeOverride(name = "gender", column = @Column(name = "customer_gender")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "customer_date_of_birth")),
            @AttributeOverride(name = "email", column = @Column(name = "customer_email")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "customer_phone_number"))
    })
    private Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "policy_id")
    private String policyId;

    @Column(name = "policy_issued_at")
    private LocalDateTime policyIssuedAt;
}
