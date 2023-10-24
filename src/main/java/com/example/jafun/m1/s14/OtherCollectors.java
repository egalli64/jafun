/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s14;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Using collectors summingInt, averagingInt, joining
 */
public class OtherCollectors {
    public static void main(String[] args) {
        List<String> words = List.of("alpha", "beta", "charlie", "delta", "echo", "foxtrot");
        System.out.println("A list of words " + words);

        // summingInt
        System.out.print("The sum of words length is ");
        System.out.println(words.stream().collect(Collectors.summingInt(String::length)));

        // averagingInt
        System.out.print("The average word length is ");
        System.out.println(words.stream().collect(Collectors.averagingInt(String::length)));

        // joining
        System.out.print("toString effect by collect-joining ");
        System.out.println(words.stream().collect(Collectors.joining(", ", "[", "]")));
    }
}
