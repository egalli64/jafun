/*
 * Introduction to Functional Programming with Java
 * 
 * Module 3 - collect from Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m3.s4.bean;

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

        System.out.print("Dogs total weight (by reducing collector) is ");
        System.out.println(dogs.stream().collect(Collectors.reducing(0.0, DogExt::getWeight, Double::sum)));
    }
}
