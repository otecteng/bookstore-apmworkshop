package com.example;

import org.springframework.stereotype.Component;

@Component
public class RemoteHystrix implements OrderFeignClient {
    @Override
    public OrderDTO createOrder(RequestOrderDTO orderRequest) {
        return null;
    }

    @Override
    public String hi() {
        return null;
    }
}
