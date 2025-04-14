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

    @Value("${QUOTE_EXCHANGE}")
    private String quoteExchange;

    @Value("${POLICY_EXCHANGE}")
    private String policyExchange;

    @Value("${INSURANCE_QUOTE_RECEIVED_QUEUE}")
    private String quoteReceivedQueue;

    @Value("${INSURANCE_POLICY_CREATED_QUEUE}")
    private String policyCreatedQueue;

    @Value("${QUOTE_RECEIVED_ROUTING_KEY}")
    private String quoteReceivedRoutingKey;

    @Value("${POLICY_CREATED_ROUTING_KEY}")
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
