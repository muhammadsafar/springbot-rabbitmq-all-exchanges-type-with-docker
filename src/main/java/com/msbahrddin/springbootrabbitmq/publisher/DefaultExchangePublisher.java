package com.msbahrddin.springbootrabbitmq.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultExchangePublisher {

    @Value("${rabbitmq.queue.name.default.A}")
    private String queueDefaultA;

    @Value("${rabbitmq.queue.name.default.B}")
    private String queueDefaultB;

    private RabbitTemplate rabbitTemplate;

    public DefaultExchangePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * in default exchange -> routing key set as queue
     * doest need exchange name parameter
     * only queue and binding
     */
    public void sendMessageDefaultExchangeQueueA(String message) {
        log.info(String.format("Message sent Default Exchange Queue A -> %s", message));
        rabbitTemplate.convertAndSend(queueDefaultA, message);
    }

    public void sendMessageDefaultExchangeQueueB(String message) {
        log.info(String.format("Message sent Default Exchange Queue B -> %s", message));
        rabbitTemplate.convertAndSend(queueDefaultB, message);
    }
}
