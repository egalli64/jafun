/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.dto.rec;

/**
 * A modern dog with extra info
 */
record DogExt(Dog dog, int age, double weight) {
    /**
     * Create the basic dog and inject it in the new record
     * 
     * @param name   dog name
     * @param owner  dog owner
     * @param age    dog age
     * @param weight dog weight
     */
    DogExt(String name, String owner, int age, double weight) {
        this(new Dog(name, owner), age, weight);
    }
}
