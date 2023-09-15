/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafp.s05;

/**
 * A modern comparable DTO
 */
record Dog(String name) implements Comparable<Dog> {
    @Override
    public int compareTo(Dog other) {
        return this.name.compareTo(other.name);
    }
}
