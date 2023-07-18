package com.pault.example.imperative;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;


@Log
public class Main {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)

        );

        // Imperative Approach
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            log.info(String.valueOf(female));
        }

        // Declarative Approach
        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .toList()
                .forEach(person -> log.info(person.toString()));




    }

    @Data
    static class Person {
        private final String name;
        private final Gender gender;

    }

    enum Gender {
        MALE, FEMALE
    }
}
