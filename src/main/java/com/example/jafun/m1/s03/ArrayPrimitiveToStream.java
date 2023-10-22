/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s03;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * How to stream a primitive array (int, long, or double)
 */
public class ArrayPrimitiveToStream {
    public static void main(String[] args) {
        System.out.println("Using an IntStream, primitive integer stream");
        IntStream is = Arrays.stream(new int[] { 1, 2, 3 });
        is.forEach(System.out::println);
        // same, in compact form
        // Arrays.stream(new int[] { 1, 2, 3 }).forEach(System.out::println);

        System.out.println("Using an LongStream, primitive long stream");
        LongStream ls = Arrays.stream(new long[] { 1, 2, 3 });
        ls.forEach(System.out::println);

        System.out.println("Using an DoubleStream, primitive double stream");
        DoubleStream ds = Arrays.stream(new double[] { 1.0, 2.0, 3.0 });
        ds.forEach(System.out::println);
    }
}
