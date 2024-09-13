/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s4.bean;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Composing predicates on JavaBeans
 */
public class PredicateComposition {
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList( //
                new Dog("Bob", "Bart", 11), //
                new Dog("Rob", "Bart", 4), //
                new Dog("Rob", "Dino", 11) //
        );

        System.out.println("A dog list: " + dogs);

        Predicate<Dog> old = dog -> dog.getAge() > 10;

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

        Predicate<Dog> rt = dog -> dog.getOwner().endsWith("rt");

        System.out.println("\nOld dogs owned by *rt:");
        for (Dog dog : dogs) {
            if (old.and(rt).test(dog)) {
                System.out.println(dog);
            }
        }

        Predicate<Dog> rob = dog -> dog.getName().equals("Rob");

        System.out.println("\nNamed Rob:");
        for (Dog dog : dogs) {
            if (rob.test(dog)) {
                System.out.println(dog);
            }
        }

        System.out.println("\nNamed Rob or owned by *rt:");
        for (Dog dog : dogs) {
            if (rob.or(rt).test(dog)) {
                System.out.println(dog);
            }
        }

        System.out.println("\nNot (named Rob or owned by *rt):");
        for (Dog dog : dogs) {
            if (rob.or(rt).negate().test(dog)) {
                System.out.println(dog);
            }
        }
    }
}
