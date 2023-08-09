package com.msbahrddin.springbootrabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultExchangeConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name.default.A}"})
    public void consumeMessageA(String message){
        log.info(String.format("Message receive from Default Exchange Queue A -> %s", message));
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name.default.B}"})
    public void consumeMessageB(String message){
        log.info(String.format("Message receive from Default Exchange Queue B -> %s", message));
    }
}
