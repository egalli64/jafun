/*
 * Introduction to Functional Programming with Java
 * 
 * Module 3 - collect from Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m3.s4;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Using Collectors.reducing
 */
public class Reducing {
    public static void main(String[] args) {
        List<Integer> values = List.of(4, 2, -23, 67, 45);
        List<Integer> empty = List.of();
        System.out.println("The values:  " + values + ", " + empty);

        // First overload, just the binary operation is required
        System.out.println("Sum of values by reducing (1): " + //
                values.stream().collect(Collectors.reducing(Integer::sum)));
        System.out.println("Sum of empty by reducing (1): " + //
                empty.stream().collect(Collectors.reducing(Integer::sum)));

        // Second overload, the identity is required too
        System.out.println("Sum of values by reducing (2): " + //
                values.stream().collect(Collectors.reducing(0, Integer::sum)));
        System.out.println("Sum of empty by reducing (2): " + //
                empty.stream().collect(Collectors.reducing(0, Integer::sum)));

        // Third overload, the mapper is required too
        System.out.println("Sum of values by reducing (3): " + //
                values.stream().collect(Collectors.reducing(0, Function.identity(), Integer::sum)));
        System.out.println("Sum of empty by reducing (3): " + //
                empty.stream().collect(Collectors.reducing(0, Function.identity(), Integer::sum)));
    }
}
