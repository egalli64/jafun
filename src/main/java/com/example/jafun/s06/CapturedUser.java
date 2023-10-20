/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafun.s06;

/**
 * A class that works on a closure
 */
public class CapturedUser {
    /**
     * By running the runnable, the called uses internal details of the caller
     * 
     * @param runnable a closure
     */
    public static void execute(Runnable runnable) {
        System.out.print("The executor receives a closure and run it: ");
        runnable.run();
    }
}
