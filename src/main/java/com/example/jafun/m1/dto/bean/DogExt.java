/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.dto.bean;

/**
 * A legacy comparable dog with extra info
 */
public class DogExt extends Dog {
    private int age;
    private double weight;

    public DogExt() {
    }

    public DogExt(String name, String owner, int age, double weight) {
        super(name, owner);
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "DogExt [age=" + age + ", weight=" + weight + ", name=" + getName() + ", owner=" + getOwner() + "]";
    }
}
