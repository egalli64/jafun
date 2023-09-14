/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafp.s04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

/**
 * Lambda syntax
 */
public class LambdaMain {
    /**
     * A verbose lambda for Comparator Functional Interface
     * <p>
     * Compare strings first by their size (shorter wins), then by the string
     * natural way
     */
    private static void example1() {
        System.out.println("Two references to objects of the same type -> an int");
        Comparator<String> lambda = (String left, String right) -> {
            int comparison = left.length() - right.length();
            return comparison == 0 ? left.compareTo(right) : comparison;
        };

        String bob = "Bob";
        String cy = "Cy";
        String tom = "Tom";
        System.out.printf("Comparing %s with %s: %d%n", bob, tom, lambda.compare(bob, tom));
        System.out.printf("Comparing %s with %s: %d%n", bob, cy, lambda.compare(bob, cy));
        System.out.println("---");
    }

    /**
     * A verbose lambda for ActionListener Functional Interface
     * <p>
     * Print the passed ActionEvent
     */
    private static void example2() {
        System.out.println("An ActionEvent -> void");
        ActionListener lambda = (ActionEvent e) -> {
            System.out.println(e);
        };

        lambda.actionPerformed(new ActionEvent(new Object(), 42, "Hello"));
        System.out.println("---");
    }

    /**
     * A more compact lambda for ActionListener Functional Interface, the compiler
     * deduces the parameter type
     * <p>
     * Print the passed ActionEvent
     */
    private static void example3() {
        System.out.println("A deduced ActionEvent -> void");
        ActionListener lambda = e -> {
            System.out.println(e);
        };

        lambda.actionPerformed(new ActionEvent(new Object(), 42, "Hello"));
        System.out.println("---");
    }

    /**
     * A no-arg lambda for Runnable Functional Interface
     * <p>
     * Print a string
     */
    private static void example4() {
        System.out.println("No parameter -> void");
        Runnable runner = () -> {
            System.out.println("Running ...");
        };

        runner.run();
        System.out.println("---");
    }

    /**
     * A compact lambda for Comparator Functional Interface, the compiler deduces
     * the parameter type and the return statement
     * <p>
     * Print the passed ActionEvent
     */
    private static void example5() {
        System.out.println("Two references to objects of the same type (implicit) -> an int");
        Comparator<String> lambda = (s, t) -> t.compareTo(s);

        String bob = "Bob";
        String tom = "Tom";
        int result = lambda.compare(bob, tom);
        System.out.printf("Comparing %s with %s: %d%n", bob, tom, result);
        System.out.println("---");
    }

    /**
     * A few lambda examples
     */
    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
    }
}
