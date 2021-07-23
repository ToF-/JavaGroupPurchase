package com.example.javagrouppurchase;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Buyer {
    private String name;
    private LocalDate birthDate;
    public Buyer(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}
