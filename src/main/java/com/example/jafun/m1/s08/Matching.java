/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s08;

import java.util.List;

/**
 * Terminal operations: allMatch, anyMatch, noneMatch
 */
public class Matching {
    public static void main(String[] args) {
        List<Integer> data = List.of(4, 2, 5, 23, 54, 11, 67, 100, 15, 83, 45);
        System.out.println(data);

        if (data.stream().allMatch(x -> x > 0)) {
            System.out.println("All the elements are positive");
        }

        if (data.stream().anyMatch(x -> x % 2 == 0)) {
            System.out.println("There is at least an even element");
        }

        if (data.stream().noneMatch(x -> x > 100)) {
            System.out.println("No element is bigger than 100");
        }
    }
}
