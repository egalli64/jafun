/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s10.bean;

import java.util.List;

/**
 * Flat map to generate a Cartesian product
 */
public class MappingFlatCartesian {
    public static void main(String[] args) {
        List<Integer> li1 = List.of(4, 45, 18);
        System.out.println("list one: " + li1);

        List<Integer> li2 = List.of(14, 5, 81);
        System.out.println("list two: " + li2);
        System.out.println("---");

        System.out.println("Cartesian product (to JavaBean)");
        li1.stream().sorted() //
                .flatMap(i -> li2.stream().sorted().map(j -> new Pair(i, j))) //
                .forEach(System.out::println);
        System.out.println("---");
    }

    /**
     * A two-integer tuple as JavaBean stub
     */
    private static class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair [first=" + first + ", second=" + second + "]";
        }
    }
}
