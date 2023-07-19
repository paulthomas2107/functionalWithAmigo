package com.pault.example.functionalinterface;

import lombok.extern.java.Log;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Log
public class _Consumer {

    public static void main(String[] args) {

        // Normal Java Function
        Customer rory = new Customer("Rory Thomas", "0788888888");
        greetCustomer(rory);

        // Functional
        greetCustomerConsumer.accept(rory);

        // BI Version
        greetCustomerConsumerV2.accept(rory, true);
        greetCustomerConsumerV2.accept(rory, false);


    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            log.info("Hello " + customer.customerName + ". Thanks for registering " + (showPhoneNumber ? customer.customerPhoneNumber : "**********"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            log.info("Hello " + customer.customerName + ". Thanks for registering " + customer.customerPhoneNumber);


    static void greetCustomer(Customer customer) {
        log.info("Hello " + customer.customerName + ". Thanks for registering " + customer.customerPhoneNumber);
    }


    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}

