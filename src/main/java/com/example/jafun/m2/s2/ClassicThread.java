/*
 * Introduction to Functional Programming with Java
 * 
 * Module 2 - FP by lambda expression
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s2;

/**
 * High-Order Function emulation in classic Java - Thread example
 * <p>
 * Given an array of thread, start then join on them. Different classic
 * approaches are shown.
 * <p>
 * Defining, creating a runnable, then a thread is usually the preferred one, at
 * least when the code to execute is short.
 */
public class ClassicThread {
    public static void main(String[] args) {
        Thread ts[] = { new Looper("L1"), //
                new Thread(new Runner(), "R1"), //
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 3; i++) {
                            try {
                                System.out.printf("%s: simulation %d%n", Thread.currentThread().getName(), i);
                                Thread.sleep((long) (Math.random() * 1_000));
                            } catch (InterruptedException e) {
                                throw new IllegalStateException(e);
                            }
                        }
                    }
                }, "R2") //
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
}
