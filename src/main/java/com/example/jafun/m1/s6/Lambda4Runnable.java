/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s6;

/**
 * Lambda syntax
 */
public class Lambda4Runnable {
    /**
     * Defining a Runnable lambda
     * <p>
     * Print a message
     */
    public static void main(String[] args) {
        System.out.println("Running a runnable\n");
        Runnable runner = () -> System.out.println("Running ...");

        runner.run();
    }
}
