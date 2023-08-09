package com.msbahrddin.springbootrabbitmq.publisher;

import com.msbahrddin.springbootrabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HeaderExchangePublisher {

    @Value("${rabbitmq.header-exchange.name}")
    private String headerExchange;

    @Value("${rabbitmq.queue.name.header.A}")
    private String queueHeaderA;

    @Value("${rabbitmq.queue.name.header.B}")
    private String queueHeaderB;

    @Value("${rabbitmq.queue.name.header.all}")
    private String queueHeaderAll;


    private RabbitTemplate rabbitTemplate;

    public HeaderExchangePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageHeaderQueueA(String message) {
        log.info(String.format("Message sent Header queue A -> %s", message));
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("header-key", message);

        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message1 = messageConverter.toMessage(message, messageProperties);
        rabbitTemplate.convertAndSend(headerExchange, "", message1);

    }

    public void sendMessageHeaderQueueB(String message) {
        log.info(String.format("Message sent Header queue B -> %s", message));
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("header-key", message);

        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message1 = messageConverter.toMessage(message, messageProperties);
        rabbitTemplate.convertAndSend(headerExchange, "", message1);

    }

    public void sendMessageHeaderQueueAll(String message) {
        log.info(String.format("Message sent Header queue All -> %s", message));
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("header-key", message);

        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message1 = messageConverter.toMessage(message, messageProperties);
        rabbitTemplate.convertAndSend(headerExchange, "", message1);

    }
}
