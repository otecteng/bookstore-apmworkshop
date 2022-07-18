package com.example;

import lombok.Data;

@Data
public class RequestOrderDTO {
    String productGuid;
    int quantity;
    double amount;
}
