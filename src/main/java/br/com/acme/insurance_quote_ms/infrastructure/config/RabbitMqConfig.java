package br.com.acme.insurance_quote_ms.infrastructure.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String INSURANCE_QUOTE_RECEIVED = "insurance-quote-received";
    public static final String INSURANCE_POLICY_CREATED = "insurance-policy-created";
}
