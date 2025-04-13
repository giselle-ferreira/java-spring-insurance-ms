package br.com.acme.insurance_quote_ms.infrastructure.repository;

import br.com.acme.insurance_quote_ms.domain.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {
}
