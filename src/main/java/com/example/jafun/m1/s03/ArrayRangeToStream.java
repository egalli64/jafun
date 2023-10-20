/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s03;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * How to stream a partial array
 */
public class ArrayRangeToStream {
    public static void main(String[] args) {
        String[] data = { "not interesting", "first", "second", "third", "not interesting" };
        System.out.println("Array -> Stream on a range in the array -> operate on it");
        Stream<String> stream = Arrays.stream(data, 1, data.length - 1);
        stream.forEach(System.out::println);
    }
}
