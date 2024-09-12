/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s3;

import java.util.concurrent.ThreadLocalRandom;

/**
 * High-Order Function in classic Java - Thread example
 * <p>
 * Given an array of thread, start then join on them. Different classic
 * approaches are shown.
 * <p>
 * Defining, creating a runnable, then a thread is usually the preferred one, at
 * least when the code to execute is short.
 */
public class HOF3Thread {
    public static void main(String[] args) {
        Thread ts[] = { new Looper("L1"), //
                new Thread(new Runner(), "R1"), //
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        aTask();
                    }
                }, "R2") //
        };

        for (

        Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.err.println("Unexpected interruption: " + e);
                Thread.currentThread().interrupt();
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
