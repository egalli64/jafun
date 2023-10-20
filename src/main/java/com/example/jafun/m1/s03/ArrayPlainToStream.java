/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s03;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * How to stream an array
 */
public class ArrayPlainToStream {
    public static void main(String[] args) {
        String[] data = { "first", "second", "third" };
        System.out.println("An array: " + Arrays.toString(data));

        // 1. Get a stream on the passed array
        Stream<String> stream = Arrays.stream(data);
        System.out.println("\nOperate on an array by stream: " + stream.toString());

        // 2. Terminal operation, consume the stream
        System.out.println("\nPrint each element:");
        stream.forEach(System.out::println);

        // Usually a pipeline is specified as a single statement
        System.out.println("\nStream data in an array, print each value:");
        Arrays.stream(data).forEach(System.out::println);
    }
}
