package com.example.javagrouppurchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcBuyerRepository implements BuyerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcBuyerRepository(JdbcTemplate jdbcTemplate) {
        jdbcTemplate = jdbcTemplate;
    }
    public Optional<Buyer> findByName(String name) {
        List<Buyer> results = jdbcTemplate.query(
                "SELECT NAME,BIRTHDATE FROM BUYER WHERE NAME=?",
                this::mapRowToBuyer,
                name);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Iterable<Buyer> findAll() {
        return jdbcTemplate.query(
                "SELECT NAME,BIRTHDATE FROM BUYER",
                this::mapRowToBuyer);
    }
    private Buyer mapRowToBuyer(ResultSet row, int rowNum) throws SQLException {
        return new Buyer(row.getString("NAME"),row.getDate("BIRTHDATE").toLocalDate());
    }
    @Override
    public Buyer save(Buyer buyer) {
        jdbcTemplate.update(
                "INSERT INTO BUYER (NAME, BIRTHDATE) VALUES (?,?)",
                buyer.getName(),
                buyer.getBirthDate());
        return buyer;
    }
}
