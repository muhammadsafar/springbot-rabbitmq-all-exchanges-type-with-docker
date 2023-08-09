package com.msbahrddin.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderExchangeConfig {

    @Value("${rabbitmq.header-exchange.name}")
    private String headerExchange;

    @Value("${rabbitmq.queue.name.header.A}")
    private String queueHeaderA;

    @Value("${rabbitmq.queue.name.header.B}")
    private String queueHeaderB;

    @Value("${rabbitmq.queue.name.header.all}")
    private String queueHeaderAll;


    @Bean
    public Queue queueHeaderA() {
        return new Queue(queueHeaderA);
    }

    @Bean
    public Queue queueHeaderB() {
        return new Queue(queueHeaderB);
    }

    @Bean
    public Queue queueHeaderAll() {
        return new Queue(queueHeaderAll);
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(headerExchange);
    }

    @Bean
    Binding bindingHeaderA() {
        return BindingBuilder
                .bind(queueHeaderA())
                .to(headersExchange())
                .where("header-key")
                .matches("queueA");
    }

    @Bean
    Binding bindingHeaderB() {
        return BindingBuilder
                .bind(queueHeaderB())
                .to(headersExchange())
                .where("header-key")
                .matches("queueB");
    }

    @Bean
    Binding bindingHeaderAll() {
        return BindingBuilder
                .bind(queueHeaderAll())
                .to(headersExchange())
                .where("header-key")
                .matches("queueAll");
    }

}
