package com.pault.example.optionals;

import lombok.extern.java.Log;

import java.util.Optional;
import java.util.function.Supplier;

@Log
public class Main {

    public static void main(String[] args) {
        String value = Optional.of("Hello1").orElse("default value");
        log.info(value);

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("Exception");
        String value2 = Optional.of("Hello2").orElseThrow(exception);
        log.info(value2);

        Optional.of("Hello3").ifPresent(log::info);
        Optional.of("ppp@ppp.com").ifPresent(email -> log.info("Sending email to " + email));
        Optional.empty()
                .ifPresentOrElse(email -> log.info("Sending email to " + email),
                        () -> log.info("Cannot Send Email"));


    }
}
