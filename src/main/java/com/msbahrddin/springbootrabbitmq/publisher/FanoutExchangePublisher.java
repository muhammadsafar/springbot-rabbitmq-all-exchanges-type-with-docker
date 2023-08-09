package com.msbahrddin.springbootrabbitmq.publisher;

import com.msbahrddin.springbootrabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FanoutExchangePublisher {


    @Value("${rabbitmq.fanout-exchange.name}")
    private String fanoutExchange;

    @Value("${rabbitmq.queue.name.fanout.A}")
    private String queueFanoutA;


    @Value("${rabbitmq.queue.name.fanout.B}")
    private String queueFanoutB;


    private RabbitTemplate rabbitTemplate;

    public FanoutExchangePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageFanoutA(User user) {
        log.info(String.format("Message sent direct message A -> %s", user.toString()));
        rabbitTemplate.convertAndSend(fanoutExchange, "", user.toString());
    }

    public void sendMessageFanoutB(User user) {
        log.info(String.format("Message sent direct message B -> %s", user.toString()));
        rabbitTemplate.convertAndSend(fanoutExchange, "", user.toString());
    }

}
