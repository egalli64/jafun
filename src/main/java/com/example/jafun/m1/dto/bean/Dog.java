/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.dto.bean;

import java.util.Objects;

/**
 * A legacy comparable dog, name first, then owner
 */
public class Dog implements Comparable<Dog> {
    private String name;
    private String owner;

    public Dog() {
    }

    public Dog(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(name, owner);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dog other = (Dog) obj;
        return Objects.equals(name, other.name) && Objects.equals(owner, other.owner);
    }

    @Override
    public String toString() {
        return "DogBean [name=" + name + ", owner=" + owner + "]";
    }
}
