/*
 * Introduction to Functional Programming with Java
 * 
 * Module 2 - FP by lambda expression
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s8;

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
