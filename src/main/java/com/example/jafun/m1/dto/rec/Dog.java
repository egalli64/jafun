/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.dto.rec;

/**
 * A modern comparable dog, name first, then owner
 */
record Dog(String name, String owner) implements Comparable<Dog> {
    @Override
    public int compareTo(Dog other) {
        if (this == other) {
            return 0;
        }
        int cmp = name.compareTo(other.name);
        if (cmp == 0) {
            return owner.compareTo(other.owner);
        }
        return cmp;
    }
}
