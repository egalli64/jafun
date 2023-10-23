/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s11.rec;

import java.util.List;

import com.example.jafun.m1.dto.rec.Dog;

/**
 * Reducing on a stream of records
 */
public class Reducing {
    public static void main(String[] args) {
        List<Dog> dogs = List.of( //
                new Dog("Bob", "Robert Redford"), //
                new Dog("Zip", "Val Kilmer"), //
                new Dog("Red", "Robert Redford"), //
                new Dog("Zip", "Andrew Scott"), //
                new Dog("Fido", "Andrew Scott") //
        );
        System.out.println("The stream operates on these dogs: " + dogs);

        System.out.print("Count the dogs having different name lengths: ");
        System.out.println(dogs.stream().map(dog -> dog.name().length()).distinct().count());

        System.out.print("Max dog name length is ");
        dogs.stream() //
                .map(dog -> dog.name().length()) //
                .distinct() //
                .max(Integer::compareTo) // or: (x, y) -> x.compareTo(y)
                .ifPresent(System.out::println);

        System.out.print("Same as above, but mapping to int (primitive): ");
        dogs.stream() //
                .mapToInt(dog -> dog.name().length()) //
                .distinct() //
                .max() //
                .ifPresent(System.out::println);
    }
}
