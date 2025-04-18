package br.com.acme.insurance_quote_ms.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "quotes")
public class QuoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @CollectionTable(name = "quote_coverages", joinColumns = @JoinColumn(name = "quote_id"))
    @MapKeyColumn(name = "coverage_name")
    @Column(name = "coverage_value")
    private Map<String, BigDecimal> coverages;

    @ElementCollection
    @CollectionTable(name = "quote_assistances", joinColumns = @JoinColumn(name = "quote_id"))
    @Column(name = "assistance")
    private List<String> assistances;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @Column(name = "policy_id")
    private String policyId;

    @Column(name = "policy_issued_at")
    private LocalDateTime policyIssuedAt;
}
