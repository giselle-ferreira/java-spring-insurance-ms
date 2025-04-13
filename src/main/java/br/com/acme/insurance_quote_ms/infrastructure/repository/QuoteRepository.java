package br.com.acme.insurance_quote_ms.infrastructure.repository;

import br.com.acme.insurance_quote_ms.domain.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {
}
