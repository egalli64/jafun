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
 * Create a primitive stream from a sequence, and an empty stream
 */
public class PrimitiveCreation {
    public static void main(String[] args) {
        System.out.println("Print each element in the stream of 12, 34, 2");
        IntStream.of(12, 34, 2).forEach(System.out::println);
        System.out.println("---");

        System.out.println("Print each element in the empty stream");
        DoubleStream.empty().forEach(System.out::println);
        System.out.println("---");
    }
}
