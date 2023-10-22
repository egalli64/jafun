/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s05;

import java.util.List;

/**
 * Two simple terminal operations: forEach and count
 */
public class SimpleTerminals {
    public static void main(String[] args) {
        List<Integer> values = List.of(11, 34, 2);

        System.out.println("Print each element in the stream - forEach()");
        values.stream().forEach(System.out::println);

        long count = values.stream().count();
        System.out.println("Count values in the stream - count(): " + count);
    }
}
