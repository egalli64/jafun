/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafp.s09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Composing comparators
 */
public class ComparatorComposition {
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList( //
                new Dog("Bob", "Robert Mitchum", 11), //
                new Dog("Rob", "Robert Redford", 4), //
                new Dog("Bob", "Robert Redford", 11) //
        );

        System.out.printf("A dog list:%n%s%n%n", dogs);

        // explicit comparer
        Comparator<Dog> byAgeExpl = (l, r) -> Integer.compare(l.age(), r.age());

        dogs.sort(byAgeExpl);
        System.out.printf("Plain comparator to sort by age (natural):%n%s%n%n", dogs);

        dogs.sort(byAgeExpl.reversed());
        System.out.printf("Plain comparator to sort by age (reversed):%n%s%n%n", dogs);

        Comparator<Dog> byNameExpl = (l, r) -> l.owner().compareTo(r.owner());
        dogs.sort(byAgeExpl.thenComparing(byNameExpl.reversed()));
        System.out.printf("Plain comparators to sort by age then by owner (reversed): %n%s%n%n", dogs);

        // using a comparer generator
        Comparator<Dog> byName = Comparator.comparing(Dog::name);
        dogs.sort(byName);
        System.out.printf("Generated comparator to sort by name:%n%s%n%n", dogs);

        Comparator<Dog> byAge = Comparator.comparingInt(Dog::age);
        dogs.sort(byAge);
        System.out.printf("Generated primitive comparator to sort by age:%n%s%n%n", dogs);

        Comparator<Dog> byOwner = Comparator.comparing(Dog::owner);
        dogs.sort(byName.thenComparing(byOwner));
        System.out.printf("Sorted by name and then owner:%n%s%n%n", dogs);

        dogs.sort(byOwner.thenComparing(byAge).reversed());
        System.out.printf("Sorted by owner and then age, all reversed:%n%s%n%n", dogs);
    }
}
