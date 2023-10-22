/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s03;

import java.util.stream.Stream;

/**
 * Creating unbounded streams by iterate and generate
 */
public class CreationUnbound {
    public static void main(String[] args) {
        System.out.println("The even numbers - size limited five");
        Stream.iterate(2, x -> x + 2).limit(5).forEach(System.out::println);
        // same, writing the lambda in a more verbose form
//        Stream.iterate(2, (Integer x) -> {
//            return x + 2;
//        }).limit(5).forEach(System.out::println);
        System.out.println("---");

        System.out.println("The odd numbers, terminated when the first one not less than 6 is found");
        Stream.iterate(1, x -> x < 6, x -> x + 2).forEach(System.out::println);
        System.out.println("---");

        System.out.println("Random numbers in [0, 1) - size limited to five");
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
        System.out.println("---");
    }
}
