/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s11;

import java.util.List;

/**
 * Using the reduce terminal operation
 */
public class Reducing {
    public static void main(String[] args) {
        List<Integer> data = List.of(4, 2, 5, 23, 54, 11, 67, 100, 15, 83, 45);
        List<Integer> empty = List.of();
        System.out.println("Summing on: " + data + " and " + empty);

        /*
         * Imperative, no stream
         */
        System.out.print("The imperative way: ");
        int resultData = 0;
        for (int value : data) {
            resultData += value;
        }

        int resultEmpty = 0;
        for (int value : empty) {
            resultEmpty += value;
        }
        System.out.println(resultData + ", " + resultEmpty + "\n---");

        /*
         * Reduce to optional (by lambda and by method reference)
         */
        System.out.print("Reduce to optional: ");
        // !!! if the stream is empty, the user won't get any feedback !!!
        data.stream().reduce((x, y) -> x + y).ifPresent(x -> System.out.print(x));
        System.out.print(", ");
        // !!! if the stream is not empty, it will throw a NPE !!!
        empty.stream().reduce(Integer::sum).ifPresentOrElse(null, () -> System.out.println(0));

        /*
         * Reduce to value (by lambda and by method reference)
         */
        System.out.print("Reduce to value: ");
        Integer sumData = data.stream().reduce(0, Integer::sum);
        Integer sumEmpty = empty.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sumData + ", " + sumEmpty);
        System.out.println("---");
    }
}
