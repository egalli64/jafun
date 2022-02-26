package com.example.jfp.s02;

import java.util.Arrays;
import java.util.Comparator;

class LongerFirstComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (left.length() == right.length()) {
            return left.compareTo(right);
        }
        return right.length() - left.length();
    }
}

public class ClassicSort {
    public static void main(String[] args) {
        String[] names = { "Tom", "Bo", "Billy", "Tony", "Kim", "Marcy", "Josh" };
        System.out.println("As created: " + Arrays.toString(names));

        Comparator<String> c = new LongerFirstComparator();
        Arrays.sort(names, c);
        System.out.println("Sorted (naturally) from longer to shorter: " + Arrays.toString(names));

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                if (left.length() == right.length()) {
                    return left.compareTo(right);
                }
                return left.length() - right.length();
            }
        });
        System.out.println("Sorted (naturally) from shorter to longer: " + Arrays.toString(names));
    }
}
