/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafp.s05;

import java.util.Objects;

/**
 * A classic comparable DTO, following JavaBean conventions
 */
class BeanDog implements Comparable<BeanDog> {
    private String name;

    public BeanDog() {
    }

    public BeanDog(String name) {
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
        BeanDog other = (BeanDog) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int compareTo(BeanDog other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "BeanDog [name=" + name + "]";
    }
}
