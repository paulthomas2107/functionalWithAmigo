package com.pault.example.combinatorpattern;

import lombok.extern.java.Log;

import java.time.LocalDate;

@Log
public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+440798222222",
                LocalDate.of(2000, 1, 1)
        );

        log.info(String.valueOf(new CustomerValidatorService().isValid(customer)));

    }
}
