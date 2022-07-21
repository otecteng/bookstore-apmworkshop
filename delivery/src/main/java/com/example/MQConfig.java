package com.example;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    @Bean
    public Queue delivery() {
        return new Queue("delivery", true);
    }

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange("default");
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(delivery()).to(orderExchange()).with("order");
    }
}