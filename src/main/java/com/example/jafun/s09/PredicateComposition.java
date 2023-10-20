/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafun.s09;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Composing predicates
 */
public class PredicateComposition {
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList( //
                new Dog("Bob", "Robert Mitchum", 11), //
                new Dog("Rob", "Robert Redford", 4), //
                new Dog("Bob", "Robert Redford", 11) //
        );

        System.out.println("A dog list: " + dogs);

        Predicate<Dog> old = dog -> dog.age() > 10;

        // we should really use java.util.stream here!
        System.out.println("\nOld dogs:");
        for (Dog dog : dogs) {
            if (old.test(dog)) {
                System.out.println(dog);
            }
        }

        System.out.println("\nNon-old dogs:");
        for (Dog dog : dogs) {
            if (old.negate().test(dog)) {
                System.out.println(dog);
            }
        }

        Predicate<Dog> redford = dog -> dog.owner().endsWith("Redford");

        System.out.println("\nOld dogs owned by Redford:");
        for (Dog dog : dogs) {
            if (old.and(redford).test(dog)) {
                System.out.println(dog);
            }
        }

        Predicate<Dog> rob = dog -> dog.name().equals("Rob");

        System.out.println("\nNamed Rob:");
        for (Dog dog : dogs) {
            if (rob.test(dog)) {
                System.out.println(dog);
            }
        }

        System.out.println("\nNamed Rob or owned by Redford:");
        for (Dog dog : dogs) {
            if (rob.or(redford).test(dog)) {
                System.out.println(dog);
            }
        }

        System.out.println("\nNot (named Rob or owned by Redford):");
        for (Dog dog : dogs) {
            if (rob.or(redford).negate().test(dog)) {
                System.out.println(dog);
            }
        }
    }
}
