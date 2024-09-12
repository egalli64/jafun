/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s3;

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
        HOF3Thread.aTask();
    }
}
