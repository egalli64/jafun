/*
 * Introduction to Functional Programming with Java
 * 
 * Module 2 - FP
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s09;

import java.util.Optional;

/**
 * Optional and FP
 */
public class OptionalFun {
    /**
     * isPresent vs ifPresent / ifPresentOrElse
     */
    private static void checkPresence() {
        Optional<String> empty = Optional.empty();
        Optional<Double> good = Optional.of(42.5);

        // imperative approach
        System.out.println("\nImperative: check with isPresent() with if or if/else");
        if (good.isPresent()) {
            System.out.println("The good value is " + good.get());
        }

        if (empty.isPresent()) {
            System.out.println("You should not see this: " + empty.get());
        } else {
            System.out.println("No value in the empty optional");
        }

        // functional approach
        System.out.println("\nFunctional: ifPresent() and consumer, or ifPresentOrElse() with also a runner");
        good.ifPresent(value -> System.out.println("The good value is " + value));

        empty.ifPresentOrElse( //
                value -> System.out.println("The bad value is " + value),
                () -> System.out.println("There's no value in this optional!"));
    }

    /**
     * isPresent + get vs filter + ifPresent
     */
    private static void checkValue() {
        Optional<Double> good = Optional.of(42.5);
        double limit = 40.0;

        System.out.println("\nImperative: check against a value");
        if (good.isPresent() && good.get() > limit) {
            System.out.println("Value is bigger than " + limit);
        }

        System.out.println("\nFunctional: check against a value by filter() and predicate");
        good.filter(v -> v > limit).ifPresent(v -> System.out.println("Value is bigger than " + limit));
    }

    public static void main(String[] args) {
        System.out.println("Working with Optional");
        checkPresence();
        checkValue();
    }
}
