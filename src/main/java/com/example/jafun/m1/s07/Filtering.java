/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s07;

import java.util.List;

/**
 * Intermediate filtering operations: filter, takeWhile, dropWhile
 */
public class Filtering {
    public static void main(String[] args) {
        List<Integer> values = List.of(1, 3, 2, 1, 5, 2);
        System.out.println("Original data: " + values);

        System.out.println("Keep the even elements");
        values.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        System.out.println("Keep odd elements, filter out from the first even element on");
        values.stream().takeWhile(x -> x % 2 != 0).forEach(System.out::println);

        System.out.println("Discard the initial odd elements, keep the other ones");
        values.stream().dropWhile(x -> x % 2 != 0).forEach(System.out::println);
    }
}
