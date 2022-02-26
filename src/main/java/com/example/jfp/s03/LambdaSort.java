package com.example.jfp.s03;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaSort {
    public static void main(String[] args) {
        String[] names = { "Tom", "Bo", "Billy", "Tony", "Kim", "Marcy", "Josh" };
        System.out.println("As created: " + Arrays.toString(names));

        Comparator<String> comparer = (String left, String right) -> {
            return left.length() == right.length() ? left.compareTo(right) : right.length() - left.length();
        };
        Arrays.sort(names, comparer);
        System.out.println("Sorted (naturally) from longer to shorter: " + Arrays.toString(names));

        Arrays.sort(names, (l, r) -> l.length() == r.length() ? l.compareTo(r) : l.length() - r.length());
        System.out.println("Sorted (naturally) from shorter to longer: " + Arrays.toString(names));
    }
}
