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
import java.util.stream.Stream;

/**
 * Using the flatMap intermediate operation
 */
public class MappingFlat {
    public static void main(String[] args) {
        List<Integer> li1 = List.of(4, 45, 18);
        System.out.println("list one: " + li1);

        List<Integer> li2 = List.of(14, 5, 81);
        System.out.println("list two: " + li2);
        System.out.println("---");

        System.out.println("Flat map to a single stream, then sort all the values");
        Stream.of(li1, li2).flatMap(List<Integer>::stream).sorted().forEach(System.out::println);
        System.out.println("---");

        // strings and nulls
        String[] data = { "A few", "good", "strings", null, "but", "also", "some", null };
        System.out.println("A string list: " + Arrays.toString(data));

        System.out.println("Flat-map each non-null string to get rid of nulls");
        Stream.of(data).flatMap(Stream::ofNullable).sorted().forEach(System.out::println);
        System.out.println("---");
    }
}
