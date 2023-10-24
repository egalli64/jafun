/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s14;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Using collectors
 */
public class CollectingByCollectors {
    public static void main(String[] args) {
        List<Integer> values = List.of(4, 2, -23, 4, -100, 45);
        System.out.println("A list " + values);

        // Collectors.toList()
        System.out.print("\nFilter positive values, collect by Collectors::toList() ");
        System.out.println(values.stream().filter(x -> x > 0).collect(Collectors.toList()));

        System.out.print("Same, by Java 16 Stream::toList() ");
        System.out.println(values.stream().filter(x -> x > 0).toList());

        // Collectors.toSet()
        System.out.print("Filter positive values, collect by Collectors::toSet() ");
        System.out.println(values.stream().filter(x -> x > 0).collect(Collectors.toSet()));

        // Collectors.counting()
        System.out.print("Filter positive values, collect by counting() ");
        System.out.println(values.stream().filter(x -> x > 0).collect(Collectors.counting()));

        System.out.print("Same, using Stream::count(): ");
        System.out.println(values.stream().filter(x -> x > 0).count());

        // Collectors.maxBy()
        System.out.print("Collect in natural order with maxBy(): ");
        values.stream().collect(Collectors.maxBy(Comparator.naturalOrder())) //
                .ifPresentOrElse(System.out::println, () -> System.out.println("No max!"));

        System.out.print("Same, using Stream::max(): ");
        values.stream().max(Comparator.naturalOrder()) //
                .ifPresent(System.out::println);

        // Collectors.minBy()
        System.out.print("Collect in natural order with minBy(): ");
        values.stream().collect(Collectors.minBy(Comparator.naturalOrder())) //
                .ifPresent(System.out::println);

        System.out.print("Same, using Stream::min(): ");
        values.stream().min(Comparator.naturalOrder()) //
                .ifPresent(System.out::println);
    }
}
