/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s03;

import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

/**
 * Complex stream generation by Stream::builder()
 */
public class StreamBuilder {
    public static void main(String[] args) {
        Builder<String> builder = Stream.builder();

        String[] data = { "one", "two", "three" };
        for (String s : data) {
            builder.accept(s);
        }

        System.out.println("Print each element in the stream built accepting strings (from an array)");
        builder.build().forEach(System.out::println);
        System.out.println("---");

        System.out.println("Print each element in the stream built adding 12, 34, 2 to it");
        Stream.<Integer>builder().add(42).add(34).add(2).build().forEach(System.out::println);
        System.out.println("---");
    }
}
