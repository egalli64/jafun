/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s7.bean;

import java.util.Objects;

/**
 * A classic comparable DTO, following JavaBean conventions
 */
class Dog implements Comparable<Dog> {
    private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
        return Objects.equals(name, other.name);
    }

    @Override
    public int compareTo(Dog other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + "]";
    }
}
