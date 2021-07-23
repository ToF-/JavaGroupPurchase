package com.example.javagrouppurchase;

import java.util.Optional;

public interface BuyerRepository {
    Iterable<Buyer> findAll();
    Optional<Buyer> findByName(String name);
    Buyer save(Buyer buyer);
}
