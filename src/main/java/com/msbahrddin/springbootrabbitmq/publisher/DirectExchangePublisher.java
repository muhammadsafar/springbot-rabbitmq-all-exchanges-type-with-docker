package com.msbahrddin.springbootrabbitmq.publisher;

import com.msbahrddin.springbootrabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DirectExchangePublisher {


    @Value("${rabbitmq.direct-exchange.name}")
    private String directExchange;


    @Value("${rabbitmq.routing.key.direct.A}")
    private String routingDirectA;

    @Value("${rabbitmq.routing.key.direct.B}")
    private String routingDirectB;

    private RabbitTemplate rabbitTemplate;

    public DirectExchangePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageDirectExchangeA(User user) {
        log.info(String.format("Message sent direct message A -> %s", user.toString()));
        rabbitTemplate.convertAndSend(directExchange, routingDirectA, user);
    }

    public void sendMessageDirectExchangeB(User user) {
        log.info(String.format("Message sent direct message B -> %s", user.toString()));
        rabbitTemplate.convertAndSend(directExchange, routingDirectB, user);
    }
}
