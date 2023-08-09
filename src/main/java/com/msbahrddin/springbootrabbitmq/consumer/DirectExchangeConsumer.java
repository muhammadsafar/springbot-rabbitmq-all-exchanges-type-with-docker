package com.msbahrddin.springbootrabbitmq.consumer;

import com.msbahrddin.springbootrabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DirectExchangeConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name.direct.A}"})
    public void consumeDirectMessageA(User user) {
        log.info(String.format("Message received Direct Message A-> %s", user.toString()));
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name.direct.B}"})
    public void consumeDirectMessageB(User user) {
        log.info(String.format("Message received Direct Message B -> %s", user.toString()));
    }
}
