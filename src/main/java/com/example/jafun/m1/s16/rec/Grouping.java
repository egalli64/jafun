/*
 * Introduction to Functional Programming with Java
 * 
 * Module 1 - Stream
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s16.rec;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.jafun.m1.dto.Weight;
import com.example.jafun.m1.dto.rec.DogExt;

/**
 * Using Collectors.groupingBy on records
 */
public class Grouping {
    private static final Function<DogExt, Weight> dogWeight = dog -> {
        double current = dog.weight();
        if (current < 3) {
            return Weight.LIGHT;
        } else if (current < 10) {
            return Weight.MEDIUM;
        } else {
            return Weight.HEAVY;
        }
    };

    private static final Predicate<DogExt> isYoung = dog -> dog.age() < 5;

    public static void main(String[] args) {
        List<DogExt> dogs = List.of( //
                new DogExt("Bob", "Tom Hanks", 7, 12.5), new DogExt("Tom", "Bob Marley", 5, 4.3), //
                new DogExt("Kim", "Wim Wenders", 4, 8.1), new DogExt("Kim", "Tom Hanks", 3, 2.5) //
        );
        System.out.println("Dogs: " + dogs);
        System.out.println("---");

        System.out.println("Grouping by owner");
        var groupedByOwner = dogs.stream().collect( //
                Collectors.groupingBy(d -> d.dog().owner()));
        for (var entry : groupedByOwner.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("---");

        System.out.println("Grouping by weight (external function)");
        var groupedByWeight = dogs.stream().collect(Collectors.groupingBy(dogWeight));
        for (var entry : groupedByWeight.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("---");

        // filter then grouping
        System.out.println("Filtering the young ones then grouping by owner");
        Map<String, List<DogExt>> youngDogsByOwner = dogs.stream().filter(isYoung) //
                .collect(Collectors.groupingBy(d -> d.dog().owner()));
        for (var entry : youngDogsByOwner.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("---");

        // grouping then filtering
        System.out.println("Grouping by owner then filtering the young ones");
        Map<String, List<DogExt>> youngDogsByAllOwner = dogs.stream() //
                .collect(Collectors.groupingBy( //
                        d -> d.dog().owner(), //
                        Collectors.filtering(isYoung, Collectors.toList())));
        for (var entry : youngDogsByAllOwner.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("---");

        // grouping and counting
        Map<String, Long> countDogsByOwner = dogs.stream()
                .collect(Collectors.groupingBy(d -> d.dog().owner(), Collectors.counting()));
        System.out.println("Counting dogs by owner: " + countDogsByOwner);
        System.out.println("---");

        // grouping then grouping
        Map<String, Map<Weight, List<DogExt>>> dogsByOwnerAndWeight = dogs.stream()
                .collect(Collectors.groupingBy(d -> d.dog().owner(), Collectors.groupingBy(dogWeight)));
        System.out.println("Dogs by owner and weight: " + dogsByOwnerAndWeight);

        // partitioning
        Map<Boolean, List<DogExt>> dogsByAge = dogs.stream().collect(Collectors.partitioningBy(isYoung));
        System.out.println("\nDogs partitioned by age: " + dogsByAge);

        // just filtering
        System.out.println("\nOnly young dogs: " + dogs.stream().filter(isYoung).collect(Collectors.toList()));

        // partitioning then grouping
        Map<Boolean, Map<Weight, List<DogExt>>> dogsByKimNameAndOwner = dogs.stream()
                .collect(Collectors.partitioningBy(isYoung, Collectors.groupingBy(dogWeight)));
        System.out.println("\nDogs partitioned by age and weight: " + dogsByKimNameAndOwner);
    }
}
