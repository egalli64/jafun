package com.example.jafp.s05;

import java.util.Collection;
import java.util.TreeSet;
import java.util.function.Supplier;

record Dog(String name) implements Comparable<Dog> {
    @Override
    public int compareTo(Dog other) {
        return this.name.compareTo(other.name);
    }
}

public class NewAsMethodReference {
    private static Dog[] dogs = { new Dog("Tom"), new Dog("Bob"), new Dog("Kim"), new Dog("Wim") };

    public static Collection<Dog> get(Supplier<Collection<Dog>> supplier) {
        Collection<Dog> result = supplier.get();
        for (Dog dog : dogs) {
            result.add(dog);
        }

        return result;
    }

    public static void main(String[] args) {
        Collection<Dog> dogs = NewAsMethodReference.get(TreeSet::new);

        System.out.println("Provided dogs (sorted)");
        dogs.forEach(System.out::println);
    }
}
