/*
 * Introduction to Functional Programming with Java
 * 
 * Module 3 - collect from Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m3.s2.rec;

import java.util.List;
import java.util.Set;

import com.example.jafun.m1.dto.rec.Dog;

/**
 * Using the collect terminal with a specialized Collector (on records)
 */
public class Collecting {
    public static void main(String[] args) {
        List<Dog> dogs = List.of( //
                new Dog("Bob", "Robert Redford"), //
                new Dog("Zip", "Val Kilmer"), //
                new Dog("Red", "Robert Redford"), //
                new Dog("Zip", "Andrew Scott"), //
                new Dog("Fido", "Andrew Scott") //
        );

        System.out.println("Dogs are: " + dogs);
        Set<String> owners = dogs.stream().collect(new DogOwnerCollector());
        System.out.println("Owners are: " + owners);
    }
}
