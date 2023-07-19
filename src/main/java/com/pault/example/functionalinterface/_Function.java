package com.pault.example.functionalinterface;

import lombok.extern.java.Log;

import java.util.function.BiFunction;
import java.util.function.Function;

@Log
public class _Function {
    public static void main(String[] args) {

        // Function Examples - takes 1 and produces 1
        int inc = incrementByOne(0);
        log.info(String.valueOf(inc));

        Integer inc2 = incrementByOneFunction.apply(2);
        log.info(String.valueOf(inc2));

        // Chain Functions
        Function<Integer, Integer> inc3 = incrementByOneFunction.andThen(multiplyBy10);
        log.info(String.valueOf(inc3.apply(4)));

        // BiFunction - takes 2 and produces 2
        log.info(String.valueOf(incrementByOneAndMultiply(4, 100)));

        log.info(String.valueOf(incrementByOneAndMultiplyBIFunction.apply(4, 100)));



    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;

    static int incrementByOne(int number) {

        return (number + 1);
    }
    static int incrementByOneAndMultiply(int number, int numberToMultiplyBy) {

        return (number + 1) * numberToMultiplyBy;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBIFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
}
