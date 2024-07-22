/*
 * Introduction to Functional Programming with Java
 * 
 * Module 2 - FP by lambda expression
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s2;

import java.util.Comparator;

/**
 * An example of classic Java comparator
 * <p>
 * The strings are ordered by size, then by alphabetic natural order
 */
class LongerFirstComparator implements Comparator<String> {
    @Override
    public int compare(String s, String t) {
        return s.length() == t.length() ? s.compareTo(t) : t.length() - s.length();
    }
}
