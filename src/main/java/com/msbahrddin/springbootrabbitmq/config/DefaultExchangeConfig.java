package com.msbahrddin.springbootrabbitmq.config;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultExchangeConfig {

    @Value("${rabbitmq.queue.name.default.A}")
    private String queueDefaultA;

    @Value("${rabbitmq.queue.name.default.B}")
    private String queueDefaultB;

    @Bean
    public Queue queueDefaultA() {
        return new Queue(queueDefaultA);
    }

    @Bean
    public Queue queueDefaultB() {
        return new Queue(queueDefaultB);
    }

}
