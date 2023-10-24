/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s12;

import java.util.List;

/**
 * Using the collect terminal operation to get:
 * <li>sum
 * <li>average
 */
public class Collecting {
    public static void main(String[] args) {
        List<Integer> data = List.of(4, 2, 5, 23, 54, 11, 67, 100, 15, 83, 45);
        System.out.println("Working on: " + data);

        CustomCollectorSum sum = data.stream() //
                .collect(CustomCollectorSum::new, //
                        CustomCollectorSum::accumulate, //
                        CustomCollectorSum::combine);
        System.out.println("Sum is " + sum.get());

        CustomCollectorAverage avg = data.stream() //
                .collect(CustomCollectorAverage::new, //
                        CustomCollectorAverage::accumulate, //
                        CustomCollectorAverage::combine);
        System.out.println("Average is " + avg.get());
    }
}
