package com.example.jafp.s04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

public class LambdaMain {
    private static void example1() {
        System.out.println("Two references to objects of the same type -> an int");
        Comparator<String> lambda = (String left, String right) -> {
            int comparison = right.length() - left.length();
            if (comparison == 0) {
                return left.compareTo(right);
            }
            return comparison;
        };

        String bob = "Bob";
        String tom = "Tom";
        int result = lambda.compare(bob, tom);
        System.out.printf("Comparing %s with %s: %d%n", bob, tom, result);
        System.out.println("---");
    }

    private static void example2() {
        System.out.println("An ActionEvent -> void");
        ActionListener lambda = (ActionEvent e) -> {
            System.out.println(e);
        };

        lambda.actionPerformed(new ActionEvent(new Object(), 42, "Hello"));
        System.out.println("---");
    }

    private static void example3() {
        System.out.println("A deduced ActionEvent -> void");
        ActionListener lambda = e -> {
            System.out.println(e);
        };

        lambda.actionPerformed(new ActionEvent(new Object(), 42, "Hello"));
        System.out.println("---");
    }

    private static void example4() {
        System.out.println("No parameter -> void");
        Runnable runner = () -> {
            System.out.println("Running ...");
        };

        runner.run();
        System.out.println("---");
    }

    private static void example5() {
        System.out.println("Two references to objects of the same type (implicit) -> an int");
        Comparator<String> lambda = (l, r) -> r.compareTo(l);

        String bob = "Bob";
        String tom = "Tom";
        int result = lambda.compare(bob, tom);
        System.out.printf("Comparing %s with %s: %d%n", bob, tom, result);
        System.out.println("---");
    }

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
    }
}
