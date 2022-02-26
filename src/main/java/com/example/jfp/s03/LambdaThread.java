package com.example.jfp.s03;

public class LambdaThread {
    public static void main(String[] args) {
        Runnable runner = () -> {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.printf("%s: simulation %d%n", Thread.currentThread().getName(), i);
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
        Thread ts[] = { new Thread(runner, "R1"), //
                new Thread(() -> {
                    for (int i = 0; i < 3; i++) {
                        try {
                            System.out.printf("%s: simulation %d%n", Thread.currentThread().getName(), i);
                            Thread.sleep((long) (Math.random() * 1_000));
                        } catch (InterruptedException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                }, "R2") //
        };

        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }

        System.out.println("Done");
    }
}
