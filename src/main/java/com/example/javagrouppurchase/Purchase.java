package com.example.javagrouppurchase;

import lombok.Data;

import java.util.Date;

@Data
public class Purchase {
    private int purchaseId;
    private Date purchaseDate;
    private double shippingFee;
    private double total;
}
