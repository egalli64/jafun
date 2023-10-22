/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s04;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Creating unbounded primitive streams by iterate and generate
 */
public class PrimitiveCreationUnbound {
    public static void main(String[] args) {
        System.out.println("The even numbers - size limited five");
        IntStream.iterate(2, x -> x + 2).limit(5).forEach(System.out::println);
        System.out.println("---");

        System.out.println("The odd numbers, terminated when the first one not less than 6 is found");
        IntStream.iterate(1, x -> x < 6, x -> x + 2).forEach(System.out::println);
        System.out.println("---");

        System.out.println("Random numbers in [0, 1) - size limited to five");
        DoubleStream.generate(Math::random).limit(5).forEach(System.out::println);
        System.out.println("---");
    }
}
