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
 * Create a stream from a sequence; an empty stream, a stream with a single
 * element or empty (so to discard null)
 */
public class Creation {
    public static void main(String[] args) {
        System.out.println("Print each element in the stream of 12, 34, 2");
        Stream.of(12, 34, 2).forEach(System.out::println);
        System.out.println("---");

        System.out.println("Print each element in the empty stream");
        Stream.empty().forEach(System.out::println);
        System.out.println("---");

        String[] elements = { "Hello", null };
        for (String element : elements) {
            System.out.println("A stream with an element, or empty (if element is null)");
            Stream<String> stream = Stream.ofNullable(element);
            System.out.println("Printing each [0 or 1] element in the stream ... ");
            stream.forEach(System.out::println);
            System.out.println("---");
        }
    }
}
