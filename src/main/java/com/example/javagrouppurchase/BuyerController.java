package com.example.javagrouppurchase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping(path="/buyers", produces = "application/json")
public class BuyerController {
    private final HashMap<String, Buyer> buyers;

    public BuyerController() {
        this.buyers = new HashMap<>();
        buyers.put("Bertrand", new Buyer("Bertrand", LocalDate.of(1990,12,22)));
        buyers.put("Alice",new Buyer("Alice", LocalDate.of(1991,02,2)));
        buyers.put("Clara",new Buyer("Clara", LocalDate.of(1990, 7, 21)));
        buyers.put("Desmond",new Buyer("Desmond", LocalDate.of(1989, 06, 03)));
    }
    @GetMapping("/{name}")
    public Buyer buyerByName(@PathVariable("name") String name) {
        if(buyers.containsKey(name)) {
            return buyers.get(name);
        }
        return null;
    }
}
