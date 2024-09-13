/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s4.bean;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Composing comparators on JavaBeans
 */
public class ComparatorComposition {
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList( //
                new Dog("Bob", "Bart", 11), //
                new Dog("Rob", "Bart", 4), //
                new Dog("Rob", "Dino", 11) //
        );

        System.out.println("Sorting these dogs: " + dogs);

        // A comparer that compares dogs by age
        Comparator<Dog> byAgeExpl = (l, r) -> Integer.compare(l.getAge(), r.getAge());

        System.out.println("\nWith a lambda comparator");
        dogs.sort(byAgeExpl);
        System.out.println("By age: " + dogs);

        // A comparer that compares dogs by name
        Comparator<Dog> byName = Comparator.comparing(Dog::getName);
        dogs.sort(byName);
        System.out.println("\nWith a comparing comparator");
        System.out.println("By name: " + dogs);

        // Comparator.reversed
        System.out.println("\nWith a reversed comparator");
        dogs.sort(byAgeExpl.reversed());
        System.out.println("By age: " + dogs);

        // Comparator.thenComparing
        System.out.println("\nWith thenComparing on two comparators");
        Comparator<Dog> byOwner = Comparator.comparing(Dog::getOwner);
        dogs.sort(byName.thenComparing(byOwner));
        System.out.println("By name and then owner: " + dogs);

        // Comparator.thenComparing and Comparator.reversed
        System.out.println("\nWith thenComparing on two comparators, the second reversed");
        dogs.sort(byName.thenComparing(byAgeExpl.reversed()));
        System.out.println("By name then reversed age: " + dogs);

        Comparator<Dog> byAge = Comparator.comparingInt(Dog::getAge);
        dogs.sort(byOwner.thenComparing(byAge).reversed());
        System.out.println("By owner and then age, both reversed: " + dogs);

        // Comparator.comparingInt
        System.out.println("\nWith a comparingInt comparator");
        dogs.sort(byAge);
        System.out.println("By age: " + dogs);
    }
}
