/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s14.bean;

import java.util.List;
import java.util.stream.Collectors;

import com.example.jafun.m1.dto.bean.DogExt;

/**
 * Working on JavaBeans with specialized reducing collectors
 */
public class DogReducing {
    public static void main(String[] args) {
        List<DogExt> dogs = List.of( //
                new DogExt("Bob", "Tom Hanks", 7, 12.5), //
                new DogExt("Tom", "Bob Marley", 5, 4.3), //
                new DogExt("Kim", "Wim Wenders", 4, 8.1) //
        );

        System.out.println("Dogs: " + dogs);

        System.out.print("Sum weights by summingDouble collector: ");
        System.out.println(dogs.stream().collect(Collectors.summingDouble(DogExt::getWeight)));
        System.out.print("Same, by map-reduce with DoubleStream::sum(): ");
        System.out.println(dogs.stream().mapToDouble(DogExt::getWeight).sum());
        System.out.println("---");

        System.out.print("Average age by averagingInt collector: ");
        System.out.println(dogs.stream().collect(Collectors.averagingInt(DogExt::getAge)));
        System.out.print("Same, by map-reduce with IntStream::average(): ");
        dogs.stream().mapToInt(DogExt::getAge).average().ifPresent(System.out::println);
        System.out.println("---");

        System.out.println("All owners: " + //
                dogs.stream().map(DogExt::getOwner).collect(Collectors.joining(", ")));
        System.out.print("All owners in brackets: ");
        System.out.println(dogs.stream().map(DogExt::getOwner).collect(Collectors.joining(", ", "[", "]")));
    }
}
