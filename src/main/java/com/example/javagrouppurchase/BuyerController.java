package com.example.javagrouppurchase;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
            System.out.println("get " + name + ":" +buyers.get(name));
            return buyers.get(name);
        }
        return null;
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Buyer postBuyer(@RequestBody Buyer buyer) {
        System.out.println("post " + buyer);
        return buyer;
    }
}
