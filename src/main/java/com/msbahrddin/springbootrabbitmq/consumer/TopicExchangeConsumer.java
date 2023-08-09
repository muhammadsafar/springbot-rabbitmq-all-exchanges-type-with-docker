package com.msbahrddin.springbootrabbitmq.consumer;

import com.msbahrddin.springbootrabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TopicExchangeConsumer<User> {

    @RabbitListener(queues = {"${rabbitmq.queue.name.topic.A}"})
    public void consumeMessageTopicQueueA(User user) {
        log.info(String.format("Message receive Topic Queue A -> %s", user.toString()));
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name.topic.B}"})
    public void consumeMessageTopicQueueB(User user) {
        log.info(String.format("Message receive Topic Queue B -> %s", user.toString()));
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name.topic.all}"})
    public void consumeMessageTopicQueueAll(User user) {
        log.info(String.format("Message receive Topic Queue All -> %s", user.toString()));
    }
}
