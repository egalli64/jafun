/*
 * Introduction to Functional Programming with Java
 * 
 * Module 2 - FP by lambda expression
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s7.rec;

/**
 * A modern comparable DTO
 */
public record Dog(String name) implements Comparable<Dog> {
    @Override
    public int compareTo(Dog other) {
        return this.name.compareTo(other.name);
    }
}
