/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s04;

import java.util.stream.IntStream;

/**
 * Full control primitive stream generation by Stream::builder()
 */
public class PrimitiveStreamBuilder {
    public static void main(String[] args) {
        IntStream.Builder builder = IntStream.builder();

        int[] data = { 1, 2, 3 };
        for (int cur : data) {
            builder.accept(cur);
        }

        System.out.println("Print each element in the stream built accepting integers (from an array)");
        builder.build().forEach(System.out::println);
        System.out.println("---");

        System.out.println("Print each element in the stream built adding 12, 34, 2 to it");
        IntStream.builder().add(42).add(34).add(2).build().forEach(System.out::println);
        System.out.println("---");
    }
}
