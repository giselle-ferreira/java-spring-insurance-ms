package br.com.acme.insurance_quote_ms.infrastructure.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${quote.exchange}")
    private String quoteExchange;

    @Value("${policy.exchange}")
    private String policyExchange;

    @Value("${insurance.quote.received.queue}")
    private String quoteReceivedQueue;

    @Value("${insurance.policy.created.queue}")
    private String policyCreatedQueue;

    @Value("${quote.received.routing.key}")
    private String quoteReceivedRoutingKey;

    @Value("${policy.created.routing.key}")
    private String policyCreatedRoutingKey;

    public String getQuoteExchange() {
        return quoteExchange;
    }

    public String getPolicyExchange() {
        return policyExchange;
    }

    public String getQuoteReceivedQueue() {
        return quoteReceivedQueue;
    }

    public String getPolicyCreatedQueue() {
        return policyCreatedQueue;
    }

    public String getQuoteReceivedRoutingKey() {
        return quoteReceivedRoutingKey;
    }

    public String getPolicyCreatedRoutingKey() {
        return policyCreatedRoutingKey;
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue QuoteReceivedQueue(){
        return new Queue(quoteReceivedQueue);
    }

    @Bean
    public DirectExchange quoteExchange(){
        return new DirectExchange(quoteExchange);
    }

    @Bean
    public Binding quoteReceivedBinding(@Qualifier("QuoteReceivedQueue") Queue quoteReceivedQueue, DirectExchange quoteExchange) {
        return BindingBuilder.bind(quoteReceivedQueue).to(quoteExchange).with(quoteReceivedRoutingKey);
    }

    @Bean
    public Queue policyCreatedQueue(){
        return new Queue(policyCreatedQueue);
    }

    @Bean
    public DirectExchange policyExchange(){
        return new DirectExchange(policyExchange);
    }

    @Bean
    public Binding policyCreatedBinding(@Qualifier("policyCreatedQueue") Queue policyCreatedQueue, DirectExchange policyExchange) {
        return BindingBuilder.bind(policyCreatedQueue).to(policyExchange).with(policyCreatedRoutingKey);
    }
}
