package com.pault.example.lambdas;

import lombok.extern.java.Log;

import java.util.function.BiFunction;

@Log
public class LambdasDemo {

    public static void main(String[] args) {

        BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
            if (name.isBlank()) {
                throw new IllegalArgumentException("");
            }
            return name.toUpperCase() + " " + age;
        };

        String upperCaseNameAndAge = upperCaseName.apply("Alex", 20);
        log.info(upperCaseNameAndAge);
    }
}
