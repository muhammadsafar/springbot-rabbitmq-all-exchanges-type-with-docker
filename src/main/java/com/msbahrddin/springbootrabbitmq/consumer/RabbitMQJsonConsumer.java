package com.msbahrddin.springbootrabbitmq.consumer;

import com.msbahrddin.springbootrabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.json_queue.name}"})
    public void consumerJsonMessage(User user) {
        LOGGER.info(String.format("Message receive JSON message -> %s", user.toString()));
    }
}
