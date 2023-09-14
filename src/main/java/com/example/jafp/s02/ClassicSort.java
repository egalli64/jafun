/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafp.s02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * High-Order Function emulation in classic Java - Strategy Example
 * <p>
 * Given an array of strings, sort it using
 * <ol>
 * <li>A comparator defined elsewhere - LongerFirstComparator
 * <li>A comparator defined and created on the fly - shorter first
 */
public class ClassicSort {
    public static void main(String[] args) {
        String[] names = { "Tom", "Bo", "Billy", "Tony", "Kim", "Marcy", "Josh" };
        System.out.println("As created: " + Arrays.toString(names));

        Comparator<String> c = new LongerFirstComparator();
        Arrays.sort(names, c);
        System.out.println("Sorted from longer to shorter, then naturally: " + Arrays.toString(names));

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s, String t) {
                return s.length() == t.length() ? s.compareTo(t) : s.length() - t.length();
            }
        });
        System.out.println("Sorted from shorter to longer, then naturally: " + Arrays.toString(names));
    }
}
