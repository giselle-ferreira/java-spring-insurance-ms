package br.com.acme.insurance_quote_ms.infrastructure.repository;

import br.com.acme.insurance_quote_ms.domain.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByDocumentNumber(String documentNumber);
}
