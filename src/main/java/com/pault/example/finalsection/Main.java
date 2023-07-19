package com.pault.example.finalsection;

import lombok.extern.java.Log;

import java.util.function.Consumer;


@Log
public class Main {

    public static void main(String[] args) {


        hello("Paul", null, value -> log.info("No Lastname provided for " + value));
        hello("Rory", "Thomas", value -> log.info("No Lastname provided for " + value));
        hello2("Rory", "Thomas", () -> log.info("No Lastname provided"));
        hello2("Caitlin", null, () -> log.info("No Lastname provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        log.info(firstName);
        if (lastName != null) {
            log.info(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        log.info(firstName);
        if (lastName != null) {
            log.info(lastName);
        } else {
            callback.run();
        }
    }
}
