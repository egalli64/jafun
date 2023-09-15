/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafp.s07;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Some predefined functional interfaces
 */
public class FunctionalExample {
    public static void main(String[] args) {
        // void -> void
        Runnable execute = () -> System.out.println("Hello Runnable");
        System.out.print("Running a runnable: ");
        execute.run();

        // T -> boolean
        Predicate<String> isOddSized = s -> s.length() % 2 == 1;
        String pString = "Hello Predicate";
        if (isOddSized.test(pString)) {
            System.out.printf("The test on predicate for '%s' succeeded%n", pString);
        }

        // T -> void
        Consumer<String> consume = System.out::println;
        consume.accept("Accepting a consumer");

        // void -> T
        Supplier<String> greeter = () -> "Hi";
        System.out.println("Getting a supplier: " + greeter.get());

        // T, R -> T
        Function<String, Integer> size = String::length;
        String fString = "Hello Function";
        System.out.printf("Applying a function on '%s': %d%n", fString, size.apply(fString));

        // T, U -> R
        BiFunction<String, Integer, String> multi = String::repeat;
        String bString = "Hello BiFunction!";
        int count = 2;
        System.out.printf("Applying a multi bi-function on '%s' %d times: '%s'%n", bString, count,
                multi.apply(bString, count));

        // T -> T
        UnaryOperator<Boolean> not = x -> !x;
        System.out.println("Applying a unary operator: " + not.apply(false));

        // T, T -> T
        BinaryOperator<Boolean> and = Boolean::logicalAnd;
        System.out.println("Applying a binary operator: " + and.apply(true, false));
    }
}
