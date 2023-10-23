/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s10;

import java.util.Arrays;
import java.util.List;

/**
 * Using the map intermediate operation
 */
public class Mapping {
    public static void main(String[] args) {
        List<Integer> values = List.of(4, 45, 18);
        System.out.println("An integer list: " + values);

        System.out.println("Map to square:");
        values.stream().map(x -> x * x).forEach(System.out::println);
        System.out.println("---");

        String[] data = { "A few", "good", "strings", "but", "also", "some", "" };
        System.out.println("A string list: " + Arrays.toString(data));

        System.out.println("Map to length, then sort");
        Arrays.stream(data).map(String::length).sorted().forEach(System.out::println);
        System.out.println("---");
    }
}
