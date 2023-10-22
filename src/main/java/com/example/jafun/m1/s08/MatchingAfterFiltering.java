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
 * Terminal allMatch after filtering
 */
public class MatchingAfterFiltering {
    public static void main(String[] args) {
        List<Integer> data = List.of(4, 2, 5, 23, 54, 11, 67, 100, 15, 83, 45);
        System.out.println(data);

        if (data.stream().filter(x -> x % 2 != 0).allMatch(x -> x < 90)) {
            System.out.println("The odd numbers are all less than 90");
        }

        // be careful in considering the result
        if (data.stream().filter(x -> x < 0).allMatch(x -> x % 2 != 0)) {
            System.out.println("The negative numbers are all odds (no element violates the condition)");
        }
    }
}
