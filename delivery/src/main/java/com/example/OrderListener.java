package com.example;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "delivery")
public class OrderListener {
    @RabbitHandler
    public void process(String message) {
        try {
            Thread.sleep(20);
            System.out.println("Delivery receive message : " + message);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

