/*
 * Introduction to Functional Programming with Java
 * 
 * Module 2 - FP by lambda expression
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * Method reference vs explicit method call in a lambda
 */
public class MethodReference {
    private static final String[] names = { "Tom", "Mo", "Kelly", "Teddie" };

    /**
     * A HOF that gets a supplier by functional interface, and add to it a few
     * strings
     * 
     * @param supplier a String collection
     * @return the populated collection
     */
    public static Collection<String> get(Supplier<Collection<String>> supplier) {
        Collection<String> result = supplier.get();
        for (String name : names) {
            result.add(name);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("As created: " + Arrays.toString(names));

        Arrays.sort(names);
        System.out.println("In natural order: " + Arrays.toString(names));

        // lambda
        Arrays.sort(names, (l, r) -> Integer.compare(l.length(), r.length()));
        System.out.println("In length order (by lambda): " + Arrays.toString(names));

        // method reference
        Arrays.sort(names, String::compareTo);
        System.out.println("In natural order (by method reference): " + Arrays.toString(names));

        List<String> list = List.of(names);

        // lambda
        System.out.println("\nPrint each element by lambda");
        list.forEach(s -> System.out.println(s));

        // method reference
        System.out.println("\nPrint each element by method reference");
        list.forEach(System.out::println);

        // new by method reference
        Collection<String> sortedNames = MethodReference.get(TreeSet::new);
        sortedNames.add("Lily");
        System.out.println("\nNames in a tree set " + sortedNames);
    }
}
