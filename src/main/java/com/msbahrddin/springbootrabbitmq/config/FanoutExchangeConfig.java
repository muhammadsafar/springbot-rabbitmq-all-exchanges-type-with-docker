package com.msbahrddin.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutExchangeConfig {

    @Value("${rabbitmq.fanout-exchange.name}")
    private String fanoutExchange;

    @Value("${rabbitmq.queue.name.fanout.A}")
    private String queueFanoutA;


    @Value("${rabbitmq.queue.name.fanout.B}")
    private String queueFanoutB;


    @Bean
    public Queue queueFanoutA() {
        return new Queue(queueFanoutA);
    }

    @Bean
    public Queue queueFanoutB() {
        return new Queue(queueFanoutB);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }


    //fanout dosnt need routing key
    @Bean
    Binding bindingFanoutA() {
        return BindingBuilder.bind(queueFanoutA()).to(fanoutExchange());
    }

    @Bean
    Binding bindingFanoutB() {
        return BindingBuilder.bind(queueFanoutB()).to(fanoutExchange());
    }


}
