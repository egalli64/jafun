package com.example.jfp.s06;

public class CapturedUser {
    public static void executor(Runnable runnable) {
        System.out.print("The executor receives a lambda and run it: ");
        runnable.run();
    }
}
