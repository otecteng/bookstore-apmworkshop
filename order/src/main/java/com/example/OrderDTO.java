package com.example;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
    String productGuid;
    int quantity;
    double amount;
    String status;
    LocalDateTime created_at;
}
