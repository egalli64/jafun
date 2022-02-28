package com.example.jfp.s06;

public class Captured {
    private static int classValue = 42;
    private double instanceValue = Math.E;

    private void capturing() {
        double local = Math.PI;

        // a lambda that captures an instance property
        Runnable r1 = () -> System.out.println("Modifying the instance variable: " + ++instanceValue);
        CapturedUser.executor(r1);

        // a lambda that captures a static data member
        Runnable r2 = () -> System.out.println("Modifying the class variable: " + ++classValue);

        CapturedUser.executor(r2);

        // a lambda that captures a local variable
        // Local variable local defined in an enclosing scope must be final or effectively final
        Runnable r3 = () -> System.out.println(local);
        CapturedUser.executor(r3);
    }

    public static void main(String[] args) {
        new Captured().capturing();
    }
}
