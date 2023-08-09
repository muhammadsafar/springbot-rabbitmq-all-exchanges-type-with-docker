package com.msbahrddin.springbootrabbitmq.consumer;

import com.msbahrddin.springbootrabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FanoutExchangeConsumer<User> {


    @RabbitListener(queues = {"${rabbitmq.queue.name.fanout.A}"})
    public void consumeFanoutMessageA(User user) {
        log.info(String.format("Message received Fanout Message A-> %s", user.toString()));
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name.fanout.B}"})
    public void consumeFanoutMessageB(User user) {
        log.info(String.format("Message received Fanout Message B-> %s", user.toString()));
    }

}
