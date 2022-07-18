package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(qualifier = "orderFeignClient", name = "order")
public interface OrderFeignClient {
    @PostMapping(value = "orders")
    OrderDTO createOrder(@RequestBody RequestOrderDTO orderRequest);
}