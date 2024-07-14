/*
 * Introduction to Functional Programming with Java
 * 
 * Module 3 - collect from Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m3.s1;

/**
 * Helper for collect terminal operation
 */
class CustomCollectorSum {
    private int result;

    /**
     * Constructor
     */
    public CustomCollectorSum() {
        this.result = 0;
    }

    /**
     * Result getter
     * 
     * @return the collected sum
     */
    public int get() {
        return result;
    }

    /**
     * Called as BiConsumer accumulator from the collector
     * 
     * @param cur the current value in the stream
     */
    public void accumulate(int cur) {
        result += cur;
    }

    /**
     * Called as BiConsumer combiner from the collector
     * 
     * @param other the other CustomCollectorAverage used for the merging
     */
    public void combine(CustomCollectorSum other) {
        result += other.result;
    }
}
