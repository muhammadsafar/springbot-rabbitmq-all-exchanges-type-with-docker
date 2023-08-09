package com.msbahrddin.springbootrabbitmq.config;

import com.msbahrddin.springbootrabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfig {

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

    @Bean
    public Queue queueTopicA() {
        return new Queue(queueTopicA);
    }

    @Bean
    public Queue queueTopicB() {
        return new Queue(queueTopicB);
    }

    @Bean
    public Queue queueTopicAll() {
        return new Queue(queueTopicAll);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Binding bindingTopicA() {
        return BindingBuilder.bind(queueTopicA()).to(topicExchange()).with(routingKeyTopicA);
    }

    @Bean
    public Binding bindingTopicB() {
        return BindingBuilder.bind(queueTopicB()).to(topicExchange()).with(routingKeyTopicB);
    }

    @Bean
    public Binding bindingTopicAll() {
        return BindingBuilder.bind(queueTopicAll()).to(topicExchange()).with(routingKeyTopicAll);
    }

}
