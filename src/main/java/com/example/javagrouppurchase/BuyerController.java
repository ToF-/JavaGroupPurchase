package com.example.javagrouppurchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@RestController
@SessionAttributes("Buyer")
@RequestMapping(path="/buyers", produces = "application/json")
public class BuyerController {
    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerController(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }
    @GetMapping("/{name}")
    public Buyer buyerByName(@PathVariable("name") String name) {
        Optional<Buyer> found = buyerRepository.findByName(name);
        if(!found.isEmpty()) {
            Buyer buyer = found.get();
            System.out.println("get " + name + ":" +buyer);
            return buyer;
        }
        return null;
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Buyer postBuyer(@RequestBody Buyer buyer) {
        System.out.println("post " + buyer);
        return buyerRepository.save(buyer);
    }
}
