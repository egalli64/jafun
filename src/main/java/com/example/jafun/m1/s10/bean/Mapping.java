/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s10.bean;

import java.util.Comparator;
import java.util.List;

import com.example.jafun.m1.dto.bean.Dog;

/**
 * Using the map intermediate operation on JavaBeans
 */
public class Mapping {
    public static void main(String[] args) {
        List<Dog> dogs = List.of( //
                new Dog("Bob", "Robert Redford"), //
                new Dog("Zip", "Val Kilmer"), //
                new Dog("Red", "Robert Redford"), //
                new Dog("Zip", "Andrew Scott"), //
                new Dog("Fido", "Andrew Scott") //
        );
        System.out.println("The stream operates on this list of dogs: " + dogs);

        System.out.println("\nMap each dog to its owner (Dog to String transformation)");
        dogs.stream().map(Dog::getOwner).forEach(System.out::println);

        System.out.println("\nMap each dog to its owner, then discard duplicate owners");
        dogs.stream().map(Dog::getOwner).distinct().forEach(System.out::println);

        System.out.println("\nMap dogs to their distinct name length");
        dogs.stream().map(dog -> dog.getName().length()).distinct().forEach(System.out::println);

        System.out.println("\nMap dogs to their distinct name length (mapToInt)");
        dogs.stream().mapToInt(dog -> dog.getName().length()).distinct().forEach(System.out::println);

        System.out.println("\nMap dogs to their distinct owner name lengths, reverse order:");
        dogs.stream().map(dog -> dog.getOwner().length()).distinct() //
                .sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
