package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderPublisher {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public boolean publish(OrderDTO order){
        ObjectMapper mapper = new ObjectMapper();
        try {
            amqpTemplate.convertAndSend("order", "delivery.*", mapper.writeValueAsString(order));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
