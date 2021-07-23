package com.example.javagrouppurchase;

import lombok.Data;

@Data
public class Bill {
    private int billId;
    private double amount;
    private String buyer;
}
