/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s06.rec;

import java.util.Comparator;
import java.util.List;

import com.example.jafun.m1.dto.rec.Dog;

/**
 * Sorting intermediate operations - using a record as base class
 */
public class Sorting {
    public static void main(String[] args) {
        List<Dog> dogs = List.of( //
                new Dog("Bob", "Robert Redford"), //
                new Dog("Al", "Val Kilmer"), //
                new Dog("Fido", "Andrew Scott") //
        );

        System.out.println("A few dogs: " + dogs);
        System.out.println("---");

        System.out.println("Sort the dogs in natural order");
        dogs.stream().sorted().forEach(System.out::println);
        System.out.println("---");

        System.out.println(" by owner");
        dogs.stream().sorted((l, r) -> l.owner().compareTo(r.owner())).forEach(System.out::println);
        System.out.println("---");

        System.out.println(" by owner using Comparator.comparing()");
        dogs.stream().sorted(Comparator.comparing(Dog::owner)).forEach(System.out::println);
        System.out.println("---");
    }
}
