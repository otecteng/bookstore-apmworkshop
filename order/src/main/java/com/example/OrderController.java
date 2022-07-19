package com.example;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("orders")
public class OrderController {
    @PostMapping
    public OrderDTO create(@RequestBody RequestOrderDTO vo) {
        OrderDTO dto = new OrderDTO();
        dto.productGuid = vo.productGuid;
        dto.amount = vo.amount;
        dto.created_at = LocalDateTime.now();
        return dto;
    }

}
