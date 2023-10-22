/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s03;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * How to stream a collection
 */
public class CollectionToStream {
    public static void main(String[] args) {
        Collection<String> data = List.of("first", "second", "third");
        System.out.println("Collection -> Stream -> operate on it");
        Stream<String> stream = data.stream();
        stream.forEach(System.out::println);

        // same, in compact form
        // List.of("first", "second", "third").stream().forEach(System.out::println);
    }
}
