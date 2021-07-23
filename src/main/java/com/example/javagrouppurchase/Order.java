package com.example.javagrouppurchase;

import lombok.Data;

@Data
public class Order {
    private int orderId;
    private String item;
    private double unitPrice;
    private int quantity;
    private String buyer;
}
