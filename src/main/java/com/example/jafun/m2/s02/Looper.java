/*
 * Introduction to Functional Programming with Java
 * 
 * Module 2 - FP
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s02;

/**
 * A full-fledged thread.
 * <p>
 * Usually this is not the preferred approach.
 */
class Looper extends Thread {
    public Looper(String name) {
        super(name);
    }

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
