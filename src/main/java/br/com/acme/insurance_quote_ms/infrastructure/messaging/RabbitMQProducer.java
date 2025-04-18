package br.com.acme.insurance_quote_ms.infrastructure.messaging;

import br.com.acme.insurance_quote_ms.infrastructure.config.RabbitMqConfig;
import br.com.acme.insurance_quote_ms.interfaces.dto.QuoteReceivedMessageDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQProducer {

    private final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMqConfig rabbitMqConfig;

    public void sendQuoteReceivedMessage(QuoteReceivedMessageDTO message){

        logger.info("Sending message to exchange: {}, routingKey: {}, message: {}",
                rabbitMqConfig.getQuoteExchange(), rabbitMqConfig.getQuoteReceivedRoutingKey(), message);

        rabbitTemplate.convertAndSend(
                rabbitMqConfig.getQuoteExchange(),
                rabbitMqConfig.getQuoteReceivedRoutingKey(),
                message
        );

        logger.info("Message sent successfully!");
    }
}
