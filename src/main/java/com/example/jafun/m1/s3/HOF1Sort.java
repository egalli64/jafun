/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * High-Order Function in classic Java - Strategy Example
 * <p>
 * Given an array of strings, sort it using
 * <ol>
 * <li>A comparator defined elsewhere - LongerFirstComparator
 * <li>A comparator defined and created on the fly - shorter first
 */
public class HOF1Sort {
    public static void main(String[] args) {
        String[] names = { "Tom", "Bo", "Billy", "Tony", "Kim", "Marcy", "Josh" };
        System.out.println("As created: " + Arrays.toString(names));

        // Simple, but I should go elsewhere to see how the comparator actually works
        Comparator<String> c = new LongerFirstComparator();
        Arrays.sort(names, c);
        System.out.println("Sorted from longer to shorter, then naturally: " + Arrays.toString(names));

        // Define an anonymous class on the spot. Clear, but too much boilerplate
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s, String t) {
                return s.length() == t.length() ? s.compareTo(t) : s.length() - t.length();
            }
        });
        System.out.println("Sorted from shorter to longer, then naturally: " + Arrays.toString(names));
    }
}
