package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private OrderFeignClient orderFeignClient;
    @GetMapping("/")
    public ProductDTO get(@RequestParam(value = "name", defaultValue = "World") String name) {
        ProductDTO dto = new ProductDTO();
        dto.name = "book";
        dto.price = 99.99;
        return dto;
    }

    @GetMapping("/createOrder")
    public OrderDTO createOrder() {
        RequestOrderDTO dto = new RequestOrderDTO();
        dto.productGuid = "1";
        dto.amount = 99.99;
        dto.quantity = 1;
        OrderDTO orderDTO = orderFeignClient.createOrder(dto);
        return orderDTO;
    }
}
