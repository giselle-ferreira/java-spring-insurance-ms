package br.com.acme.insurance_quote_ms.infrastructure.messaging;

import br.com.acme.insurance_quote_ms.application.service.QuoteService;
import br.com.acme.insurance_quote_ms.interfaces.dto.PolicyCreatedMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
    private final QuoteService quoteService;

    public RabbitMQConsumer(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @RabbitListener(queues = "${insurance.policy.created.queue}")
    public void listenPolicyCreatedMessage(Message<PolicyCreatedMessageDTO> message){

        logger.info("Message consumed: {}", message);

        quoteService.updateQuoteWithPolicy(
                message.getPayload().id(),
                message.getPayload().policyId(),
                message.getPayload().policyIssuedAt()
        );
    }
}
