package br.com.acme.insurance_quote_ms.infrastructure.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import lombok.Getter;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
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

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue quoteReceivedQueue(){
        return new Queue(quoteReceivedQueue, true, false, false);
    }

    @Bean
    public DirectExchange quoteExchange(){
        return new DirectExchange(quoteExchange, true, false);
    }

    @Bean
    public Binding quoteReceivedBinding(@Qualifier("quoteReceivedQueue") Queue quoteReceivedQueue, DirectExchange quoteExchange) {
        return BindingBuilder.bind(quoteReceivedQueue).to(quoteExchange).with(quoteReceivedRoutingKey);
    }

    @Bean
    public Queue policyCreatedQueue(){
        return new Queue(policyCreatedQueue, true, false, false);
    }

    @Bean
    public DirectExchange policyExchange(){
        return new DirectExchange(policyExchange, true, false);
    }

    @Bean
    public Binding policyCreatedBinding(@Qualifier("policyCreatedQueue") Queue policyCreatedQueue, DirectExchange policyExchange) {
        return BindingBuilder.bind(policyCreatedQueue).to(policyExchange).with(policyCreatedRoutingKey);
    }
}
