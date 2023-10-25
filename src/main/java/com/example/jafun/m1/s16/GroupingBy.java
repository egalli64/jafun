/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s16;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Using Collectors.groupingBy
 */
public class GroupingBy {
    public static void main(String[] args) {
        List<Integer> values = List.of(4, 0, 5, -23, 54, -11, 0, -11, 5, -23, 54);
        System.out.println("Working on " + values);

        System.out.println("Grouping by sign to List:");
        Map<Integer, List<Integer>> bySign = values.stream() //
                .collect(Collectors.groupingBy(Integer::signum));
        for (var entry : bySign.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Grouping by sign to TreeSet:");
        java.util.Map<Integer, TreeSet<Integer>> bySignOrederedNoDuplicates = values.stream() //
                .collect(Collectors.groupingBy( //
                        Integer::signum, //
                        Collectors.toCollection(TreeSet::new)));
        for (var entry : bySignOrederedNoDuplicates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Grouping by sign then parity to map of boolean to List:");
        var bySignThenParity = values.stream() //
                .collect(Collectors.groupingBy( //
                        Integer::signum, //
                        Collectors.groupingBy(x -> x % 2 == 0)));
        for (var entry : bySignThenParity.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
