/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * High-Order Function in modern Java - Strategy Example
 */
public class Lambda1Sort {
    /**
     * Given an array of strings, sort it using
     * <li>A comparator defined as a lambda
     * <li>Passing directly a lambda to sort
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        String[] names = { "Tom", "Bo", "Billy", "Tony", "Kim", "Marcy", "Josh" };
        System.out.println("As created: " + Arrays.toString(names));

        // Explicitly define a lambda comparator, and then pass it to sort()
        Comparator<String> comparer = (String s, String t) -> {
            return s.length() == t.length() ? s.compareTo(t) : t.length() - s.length();
        };
        Arrays.sort(names, comparer);
        System.out.println("Sorted from longer to shorter, then naturally: " + Arrays.toString(names));

        // Pass a lambda to sort(), that matches to the required Comparator
        Arrays.sort(names, (s, t) -> s.length() == t.length() ? s.compareTo(t) : s.length() - t.length());
        System.out.println("Sorted from shorter to longer, then naturally: " + Arrays.toString(names));
    }
}
