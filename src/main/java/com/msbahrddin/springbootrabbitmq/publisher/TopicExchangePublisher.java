package com.msbahrddin.springbootrabbitmq.publisher;

import com.msbahrddin.springbootrabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TopicExchangePublisher {

    @Value("${rabbitmq.topic-exchange.name}")
    private String topicExchange;

    @Value("${rabbitmq.queue.name.topic.A}")
    private String queueTopicA;

    @Value("${rabbitmq.queue.name.topic.B}")
    private String queueTopicB;

    @Value("${rabbitmq.queue.name.topic.all}")
    private String queueTopicAll;

    @Value("${rabbitmq.routing.key.topic.A}")
    private String routingKeyTopicA;

    @Value("${rabbitmq.routing.key.topic.B}")
    private String routingKeyTopicB;

    @Value("${rabbitmq.routing.key.topic.all}")
    private String routingKeyTopicAll;


    private RabbitTemplate rabbitTemplate;

    public TopicExchangePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageTopicExchangeA(User user) {
        log.info(String.format("Message sent topic message A -> %s", user.toString()));
        rabbitTemplate.convertAndSend(topicExchange, routingKeyTopicA, user);
    }

    public void sendMessageTopicExchangeB(User user) {
        log.info(String.format("Message sent topic message B -> %s", user.toString()));
        rabbitTemplate.convertAndSend(topicExchange, routingKeyTopicB, user);
    }

    public void sendMessageTopicExchangeAll(User user) {
        log.info(String.format("Message sent topic message All -> %s", user.toString()));
        rabbitTemplate.convertAndSend(topicExchange, routingKeyTopicAll, user);
    }


}
