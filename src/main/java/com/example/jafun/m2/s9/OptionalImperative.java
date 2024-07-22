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
 * Using Optional in the imperative way
 * <p>
 * It is not wrong, but it doesn't look right in modern Java
 */
public class OptionalImperative {
    /**
     * Check if a "good" value is available by isPresent
     */
    private static void checkPresence() {
        Optional<String> empty = Optional.empty();
        Optional<Double> good = Optional.of(42.5);

        System.out.println("\nCheck with isPresent() in an if or if/else statement");
        if (good.isPresent()) {
            System.out.println("The good value is " + good.get());
        }

        if (empty.isPresent()) {
            System.out.println("You should not see this: " + empty.get());
        } else {
            System.out.println("No value in the empty optional");
        }
    }

    /**
     * Check for a value by isPresent + get
     */
    private static void checkValue() {
        Optional<Double> good = Optional.of(42.5);
        double limit = 40.0;

        System.out.println("\nCheck against a value");
        if (good.isPresent() && good.get() > limit) {
            System.out.println("Value is bigger than " + limit);
        }
    }

    public static void main(String[] args) {
        System.out.println("Working with Optional in the imperative way");
        checkPresence();
        checkValue();
    }
}
