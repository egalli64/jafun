/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafun.s02;

/**
 * A runnable class, implementing the method to be run in a new thread
 */
class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.printf("%s: simulation %d%n", Thread.currentThread().getName(), i);
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
