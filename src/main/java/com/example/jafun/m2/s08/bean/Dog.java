/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s08.bean;

import java.util.Objects;

/**
 * A JavaBean DTO
 */
public class Dog {
    private String name;
    private String owner;
    private int age;

    public Dog() {
    }

    public Dog(String name, String owner, int age) {
        this.name = name;
        this.owner = owner;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, owner);
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
        return age == other.age && Objects.equals(name, other.name) && Objects.equals(owner, other.owner);
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + ", owner=" + owner + ", age=" + age + "]";
    }
}
