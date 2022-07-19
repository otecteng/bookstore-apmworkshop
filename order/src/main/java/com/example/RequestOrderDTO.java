package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class RequestOrderDTO {
    public String getProductGuid() {
        return productGuid;
    }

    public void setProductGuid(String productGuid) {
        this.productGuid = productGuid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String productGuid;
    public int quantity;
    public double amount;
}
