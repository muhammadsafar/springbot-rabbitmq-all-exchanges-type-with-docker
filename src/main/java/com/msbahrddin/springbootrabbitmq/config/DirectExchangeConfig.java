package com.msbahrddin.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfig {

    @Value("${rabbitmq.direct-exchange.name}")
    private String directExchange;

    @Value("${rabbitmq.queue.name.direct.A}")
    private String queueDirectA;

    @Value("${rabbitmq.queue.name.direct.B}")
    private String queueDirectB;


    @Value("${rabbitmq.routing.key.direct.A}")
    private String routingDirectA;

    @Value("${rabbitmq.routing.key.direct.B}")
    private String routingDirectB;


    @Bean
    public Queue queueDirectA() {
        return new Queue(queueDirectA);
    }

    @Bean
    public Queue queueDirectB() {
        return new Queue(queueDirectB);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(directExchange);
    }

    @Bean
    Binding bindingDirectA() {
        return BindingBuilder.bind(queueDirectA()).to(directExchange()).with(routingDirectA);
    }

    @Bean
    Binding bindingDirectB() {
        return BindingBuilder.bind(queueDirectB()).to(directExchange()).with(routingDirectB);
    }


}
