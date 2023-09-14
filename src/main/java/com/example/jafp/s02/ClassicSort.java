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
 * <li>A LongerFirstComparator
 * <li>A new Comparator defined and created on the fly - shorter first
 */
public class ClassicSort {
    public static void main(String[] args) {
        String[] names = { "Tom", "Bo", "Billy", "Tony", "Kim", "Marcy", "Josh" };
        System.out.println("As created: " + Arrays.toString(names));

        Comparator<String> c = new LongerFirstComparator();
        Arrays.sort(names, c);
        System.out.println("Sorted (naturally) from longer to shorter: " + Arrays.toString(names));

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                if (left.length() == right.length()) {
                    return left.compareTo(right);
                }
                return left.length() - right.length();
            }
        });
        System.out.println("Sorted (naturally) from shorter to longer: " + Arrays.toString(names));
    }
}

/**
 * An example of classic Java comparator.
 * <p>
 * The strings are ordered by size, then by natural order
 */
class LongerFirstComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (left.length() == right.length()) {
            return left.compareTo(right);
        }
        return right.length() - left.length();
    }
}
