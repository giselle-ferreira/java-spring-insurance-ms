package br.com.acme.insurance_quote_ms.infrastructure.messaging;

import br.com.acme.insurance_quote_ms.infrastructure.config.RabbitMqConfig;
import br.com.acme.insurance_quote_ms.interfaces.dto.QuoteReceivedMessageDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMqConfig rabbitMqConfig;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate, RabbitMqConfig rabbitMqConfig) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMqConfig = rabbitMqConfig;
    }

    public void sendQuoteReceivedMessage(Message<QuoteReceivedMessageDTO> message){

        rabbitTemplate.convertAndSend(
                rabbitMqConfig.getQuoteExchange(),
                rabbitMqConfig.getQuoteReceivedRoutingKey(),
                message
        );
    }
}
