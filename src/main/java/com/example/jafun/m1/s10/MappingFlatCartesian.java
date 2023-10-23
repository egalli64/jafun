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
 * Using the flatMap intermediate operation to generate a Cartesian product
 */
public class MappingFlatCartesian {
    public static void main(String[] args) {
        List<Integer> li1 = List.of(4, 45, 18);
        System.out.println("list one: " + li1);

        List<Integer> li2 = List.of(14, 5, 81);
        System.out.println("list two: " + li2);
        System.out.println("---");

        System.out.println("Cartesian product (to int array)");
        li1.stream().sorted() //
                .flatMap(i -> li2.stream().sorted().map(j -> new int[] { i, j })) //
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("---");
    }
}
