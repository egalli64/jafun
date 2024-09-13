/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s7;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * Method reference vs explicit method call in a lambda
 */
public class MethodReferenceExamples {
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
        System.out.println("An array of strings, as created: " + Arrays.toString(names));

        Arrays.sort(names);
        System.out.println("In natural order: " + Arrays.toString(names));

        // pass a lambda to sort()
        Arrays.sort(names, (l, r) -> Integer.compare(l.length(), r.length()));
        System.out.println("In length order (by lambda): " + Arrays.toString(names));

        // pass a method reference to sort()
        Arrays.sort(names, String::compareTo);
        System.out.println("In natural order (by method reference): " + Arrays.toString(names));

        List<String> list = List.of(names);

        // lambda
        System.out.println("\nPrint each element by lambda");
        list.forEach(s -> System.out.println(s));

        // pass a method reference to forEach()
        System.out.println("\nPrint each element by method reference");
        list.forEach(System.out::println);

        // pass new as method reference to get()
        Collection<String> sortedNames = MethodReferenceExamples.get(TreeSet::new);
        sortedNames.add("Lily");
        System.out.println("\nNames in a tree set " + sortedNames);
    }
}
