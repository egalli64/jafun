/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s01;

import java.util.Collection;
import java.util.List;

/**
 * How to pass code to a stream method by lambda
 */
public class LambdaExample {
    public static void main(String[] args) {
        Collection<String> data = List.of("first", "second", "third");
        System.out.println("The input list: " + data);

        System.out.println("\nPrint each element in the imperative way");
        for (String s : data) {
            System.out.println(s);
        }

        System.out.println("\nSame by stream, invoking forEach(), passing an explicit lambda to it");
        data.stream().forEach((String s) -> System.out.println(s));

        System.out.println("\nCompact lambda");
        data.stream().forEach(s -> System.out.println(s));

        System.out.println("\nMethod reference");
        data.stream().forEach(System.out::println);
    }
}
