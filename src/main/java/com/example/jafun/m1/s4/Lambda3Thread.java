/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s4;

import java.util.concurrent.ThreadLocalRandom;

/**
 * High-Order Function in modern Java - Thread example
 */
public class Lambda3Thread {
    /**
     * Given an array of thread, start then join on them. Different functional
     * approaches are shown.
     * <p>
     * Lambda and, when possible, method reference are the preferred approaches
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        Runnable runner = () -> aTask();
        Thread ts[] = { new Thread(runner, "R1"), //
                new Thread(() -> aTask(), "R2"), //
                new Thread(Lambda3Thread::aTask, "R3") //
        };

        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }

        System.out.println("Done");
    }

    /**
     * Code executed on different threads - synchronized in printf()
     * 
     * @param iterationId
     */
    public static void aTask() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s @%d\n", Thread.currentThread().getName(), System.currentTimeMillis() % 10_000);

            /*-
             * Simulate a variable-length task
             *  
             * Using Thread.sleep() in production code is rarely a good idea
             */
            try {
                Thread.sleep((long) (ThreadLocalRandom.current().nextDouble() * 100));
            } catch (InterruptedException e) {
                System.err.println("Unexpected interruption: " + e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
