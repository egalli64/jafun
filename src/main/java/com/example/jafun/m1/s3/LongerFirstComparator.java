/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s3;

import java.util.Comparator;

/**
 * An example of classic Java comparator
 * <p>
 * The strings are ordered by size, then by alphabetic natural order
 */
public class LongerFirstComparator implements Comparator<String> {
    @Override
    public int compare(String s, String t) {
        return s.length() == t.length() ? s.compareTo(t) : t.length() - s.length();
    }
}
