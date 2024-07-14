/*
 * Introduction to Functional Programming with Java
 * 
 * Module 3 - collect from Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m3.s5;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * More examples using Collectors.groupingBy
 */
public class MoreGroupingBy {
    public static void main(String[] args) {
        List<Integer> values = List.of(4, 0, 5, -23, 54, -11, 0, -11, 5, -23, 54);
        System.out.println("Working on " + values);

        System.out.println("Grouping by sign then filter even:");
        var bySignThenEven = values.stream().collect( //
                Collectors.groupingBy(Integer::signum, //
                        Collectors.filtering(x -> x % 2 == 0, Collectors.toList())));
        for (var entry : bySignThenEven.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Same, but filter first then grouping:");
        var filterEvenThenGroupBySign = values.stream().filter(x -> x % 2 == 0) //
                .collect(Collectors.groupingBy(Integer::signum));
        for (var entry : filterEvenThenGroupBySign.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("---");

        System.out.println("Grouping by sign then add them up:");
        var bySignAdd = values.stream().collect( //
                Collectors.groupingBy(Integer::signum, //
                        Collectors.reducing(0, i -> i, Integer::sum)));
        for (var entry : bySignAdd.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("---");

        System.out.println("Grouping by sign then count them:");
        var bySignCounting = values.stream().collect( //
                Collectors.groupingBy(Integer::signum, Collectors.counting()));
        for (var entry : bySignCounting.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("---");

        System.out.println("Grouped by element, counting, sending the result in a TreeMap:");
        System.out.println(values.stream().collect( //
                Collectors.groupingBy(i -> i, TreeMap::new, Collectors.counting())));
        System.out.println("---");
    }
}
