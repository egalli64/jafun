/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s11;

import java.util.List;

/**
 * Using the specialized reduce terminal operation: count, max, min, sum
 */
public class SpecializedReducing {
    public static void main(String[] args) {
        List<Integer> data = List.of(4, 2, 5, 23, 54, 11, 67, 100, 15, 83, 45);
        System.out.println("Operating on: " + data);

        /*
         * mapToLong(e -> 1L).reduce(0, Long::sum) vs count()
         */
        System.out.print("Reduce to sum after mapping to 1 vs count(): ");
        System.out.print(data.stream().mapToLong(e -> 1L).reduce(0, Long::sum));
        System.out.print(", ");
        System.out.println(data.stream().count());

        /*
         * reduce(Integer::max) vs max()
         */
        System.out.print("Reduce to max vs max(): ");
        data.stream().reduce(Integer::max).ifPresent(System.out::print);
        System.out.print(", ");
        data.stream().max(Integer::compareTo).ifPresent(System.out::println);

        /*
         * reduce(0, Integer::sum) vs sum()
         */
        System.out.print("Reduce to sum vs sum() - on a primitive stream: ");
        System.out.print(data.stream().reduce(0, Integer::sum));
        System.out.print(", ");
        // Integer::intValue could be used to extract the primitive
        System.out.println(data.stream().mapToInt(i -> i).sum());

        /*
         * Other examples
         */
        System.out.print("\nMapping even/odd to 0/1, then sum() to count the odd values: ");
        System.out.println(data.stream().mapToInt(x -> x % 2 == 0 ? 0 : 1).sum());

        System.out.print("Same: filter odd values then count() them: ");
        System.out.println(data.stream().filter(x -> x % 2 != 0).count());
    }
}
