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
class CustomCollectorAverage {
    private int sum;
    private int count;

    /**
     * Constructor
     */
    public CustomCollectorAverage() {
        this.sum = 0;
        this.count = 0;
    }

    /**
     * Result getter
     * 
     * @return the collected average
     */
    public double get() {
        return count == 0 ? 0.0 : (double) sum / count;
    }

    /**
     * Called as BiConsumer accumulator from the collector
     * 
     * @param cur the current value in the stream
     */
    public void accumulate(int cur) {
        sum += cur;
        count += 1;
    }

    /**
     * Called as BiConsumer combiner from the collector
     * 
     * @param other the other CustomCollectorAverage used for the merging
     */
    public void combine(CustomCollectorAverage other) {
        sum += other.sum;
        count += other.count;
    }
}
