/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s06;

import java.util.List;

/**
 * Filtering intermediate operations: distinct, limit, skip
 */
public class StatefulFiltering {
    public static void main(String[] args) {
        List<Integer> values = List.of(1, 3, 2, 1, 5, 2);
        System.out.println("Original data: " + values);

        System.out.println("Keeping only distinct() elements");
        values.stream().distinct().forEach(System.out::println);

        System.out.println("Keeping first elements by limit(3)");
        values.stream().limit(3).forEach(System.out::println);

        System.out.println("Skipping first elements by skip(3)");
        values.stream().skip(3).forEach(System.out::println);
    }
}
