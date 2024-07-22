/*
 * Introduction to Functional Programming with Java
 * 
 * Module 2 - FP by lambda expression
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s9;

import java.util.Optional;

/**
 * Using Optional in the functional way
 */
public class OptionalModern {
    /**
     * Check if a "good" value is available by ifPresent / ifPresentOrElse
     */
    private static void checkPresence() {
        Optional<String> empty = Optional.empty();
        Optional<Double> good = Optional.of(42.5);

        System.out.println("\nPassing a consumer to ifPresent()");
        good.ifPresent(value -> System.out.println("The good value is " + value));

        System.out.println("Passing a consumer and a runner to ifPresentOrElse()");
        empty.ifPresentOrElse( //
                value -> System.out.println("The bad value is " + value),
                () -> System.out.println("There's no value in this optional!"));
    }

    /**
     * Check for a value by filter + ifPresent
     */
    private static void checkValue() {
        Optional<Double> good = Optional.of(42.5);
        double limit = 40.0;

        System.out.println("\nCheck against a value by filter() and predicate, then using ifPresent");
        good.filter(v -> v > limit).ifPresent(v -> System.out.println("Value is bigger than " + limit));
    }

    public static void main(String[] args) {
        System.out.println("Working with Optional in a functional way");
        checkPresence();
        checkValue();
    }
}
