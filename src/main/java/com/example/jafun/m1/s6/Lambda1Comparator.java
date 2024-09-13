/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s6;

import java.util.Comparator;

/**
 * Lambda syntax
 */
public class Lambda1Comparator {
    /**
     * Using the Comparator Functional Interface
     * <p>
     * Compare strings first by their size (shorter wins), then by the string
     * natural way
     */
    public static void main(String[] args) {
        System.out.println("Compare two strings in a custom way\n");
        Comparator<String> lambda = (String left, String right) -> {
            int comparison = left.length() - right.length();
            return comparison == 0 ? left.compareTo(right) : comparison;
        };

        String[] names = { "Bob", "Cy", "Tom" };

        for (String left : names) {
            for (String right : names) {
                System.out.printf("%s with %s gives %d%n", left, right, lambda.compare(left, right));
            }
        }
    }
}
