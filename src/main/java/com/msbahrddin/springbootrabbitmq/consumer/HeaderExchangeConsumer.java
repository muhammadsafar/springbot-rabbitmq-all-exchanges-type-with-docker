package com.msbahrddin.springbootrabbitmq.consumer;

import com.msbahrddin.springbootrabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HeaderExchangeConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name.header.A}"})
    public void consumeHeaderMessageA(String message) {
        log.info(String.format("Message received Header Message A-> %s", message));
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name.header.B}"})
    public void consumeHeaderMessageB(String message) {
        log.info(String.format("Message received Header Message B-> %s", message));
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name.header.all}"})
    public void consumeHeaderMessageAll(String message) {
        log.info(String.format("Message received Header Message All-> %s", message));
    }

}
