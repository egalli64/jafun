/*
 * Introduction to Functional Programming with Java
 * 
 * Module 2 - FP by lambda expression
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s3;

/**
 * A runnable class, implementing the method to be run in a new thread
 */
class Runner implements Runnable {
    @Override
    public void run() {
        HOF3Thread.aTask();
    }
}
