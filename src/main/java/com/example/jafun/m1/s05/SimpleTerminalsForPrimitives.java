/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s05;

import java.util.Arrays;

/**
 * Two simple terminal operations for primitive streams: forEach and count
 */
public class SimpleTerminalsForPrimitives {
    public static void main(String[] args) {
        int[] values = { 11, 34, 2 };

        System.out.println("Print each element in the int stream - forEach()");
        Arrays.stream(values).forEach(System.out::println);

        long count = Arrays.stream(values).count();
        System.out.println("Count values in the int stream - count(): " + count);
    }
}
