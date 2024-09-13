/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s3;

import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntConsumer;

/**
 * Some predefined functional interfaces specialized for primitives
 */
public class FunctionalPrimitiveExample {
    public static void main(String[] args) {
        // double -> boolean
        DoublePredicate isPositive = x -> x > 0;
        double aValue = Math.PI;
        if (isPositive.test(aValue)) {
            System.out.printf("Test on a double predicate for %s succeeded%n", aValue);
        }

        // int -> void
        IntConsumer consume = i -> System.out.printf("Accepting an int-consumer on %d%n", i);
        consume.accept(42);

        // double -> int
        DoubleToIntFunction intFloor = value -> (int) Math.floor(value);
        System.out.println("Applying a double-to-int function gives " + intFloor.applyAsInt(Math.E));
    }
}
