/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s04;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Creating ranged primitive streams
 */
public class PrimitiveRanges {
    public static void main(String[] args) {
        System.out.println("Right open range on primitive int stream [40..43)");
        IntStream.range(40, 43).forEach(System.out::println);

        System.out.println("Closed range on primitive long stream [9223372036854775805..9223372036854775807]");
        LongStream.rangeClosed(Long.MAX_VALUE - 2, Long.MAX_VALUE).forEach(System.out::println);
    }
}
