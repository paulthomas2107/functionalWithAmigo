package com.pault.example.streams;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

@Log
public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Bobby", Gender.NOT_TOLD)

        );


        // Genders
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(gender -> log.info(gender.toString()));

        // Names
        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(log::info);

        // Length of name
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(name -> log.info(String.valueOf(name)));

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(number -> log.info(String.valueOf(number)));


    }

    @Data
    static class Person {
        private final String name;
        private final Gender gender;

    }

    enum Gender {
        MALE, FEMALE, NOT_TOLD
    }

}

