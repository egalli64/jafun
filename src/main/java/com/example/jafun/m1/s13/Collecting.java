/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s13;

import java.util.List;

/**
 * Using the collect terminal to get a list (of even values) by a Collector
 */
public class Collecting {
    public static void main(String[] args) {
        List<Integer> data = List.of(4, 2, 5, 23, 54, 11, 67, 100, 15, 83, 45);
        System.out.println("Working on " + data);

        List<Integer> collected = data.stream().collect(new EvenCollector());
        System.out.println("Even values are " + collected);
    }
}
