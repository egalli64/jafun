/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s10.rec;

import java.util.Arrays;
import java.util.List;

import com.example.jafun.m1.dto.rec.Dog;

/**
 * Using map and flat map intermediate operations on records
 */
public class MapPlusFlatMap {
    public static void main(String[] args) {
        List<Dog> dogs = List.of( //
                new Dog("Bob", "Robert Redford"), //
                new Dog("Zip", "Val Kilmer"), //
                new Dog("Fido", "Andrew Scott") //
        );
        System.out.println("Dogs are: " + dogs);

        System.out.print("Characters used in their owner names are >");
        dogs.stream() //
                .map(Dog::owner) //
                .map(s -> s.split("")) //
                .flatMap(Arrays::stream) //
                .map(String::toLowerCase) //
                .distinct() //
                .sorted() //
                .forEach(System.out::print);
        System.out.println('<');
    }
}
