package com.pault.example.combinatorpattern;

import lombok.extern.java.Log;

import java.time.LocalDate;


@Log
public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+940798222222",
                LocalDate.of(2000, 1, 1)
        );

        log.info(String.valueOf(new CustomerValidatorService().isValid(customer)));

        // If Customer is valid can be stored in DB....

        // Using combination pattern
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);

        log.info(String.valueOf(result));

        if (result != CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }


    }
}
