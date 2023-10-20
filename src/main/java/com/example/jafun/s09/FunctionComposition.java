/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafun.s09;

import java.util.function.Function;

/**
 * Composing functions
 */
public class FunctionComposition {
    public static void main(String[] args) {
        Function<Integer, Integer> doubler = x -> x * 2;
        Function<Integer, Integer> squarer = x -> x * x;

        Function<Integer, Integer> doubledAndSquarer = doubler.andThen(squarer);
        System.out.println("(2 * 3) ^ 2: " + doubledAndSquarer.apply(3));

        Function<Integer, Integer> doubledComposedSquare = doubler.compose(squarer);
        System.out.println("2 * (3 ^ 2): " + doubledComposedSquare.apply(3));
    }
}
