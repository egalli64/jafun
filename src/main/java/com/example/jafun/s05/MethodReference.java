/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafun.s05;

import java.util.Arrays;
import java.util.List;

/**
 * Method reference vs explicit method call
 */
public class MethodReference {
    public static void main(String[] args) {
        String[] names = { "tom", "Bob", "kelly", "Ted" };
        System.out.println("As created: " + Arrays.toString(names));

        Arrays.sort(names);
        System.out.println("Natural order: " + Arrays.toString(names));

        // lambda
        Arrays.sort(names, (l, r) -> l.compareToIgnoreCase(r));
        System.out.println("Natural order (ignore case) by lambda: " + Arrays.toString(names));

        // back to natural order
        Arrays.sort(names);

        // method reference
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println("Natural order (ignore case) by method reference: " + Arrays.toString(names));

        List<String> list = List.of(names);

        // lambda
        System.out.println("\nPrint each element by lambda");
        list.forEach(s -> System.out.println(s));

        // method reference
        System.out.println("\nPrint each element by method reference");
        list.forEach(System.out::println);
    }
}
