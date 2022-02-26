package com.example.jfp.s02;

class Looper extends Thread {
    public Looper(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.printf("%s: simulation %d%n", Thread.currentThread().getName(), i);
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.printf("%s: simulation %d%n", Thread.currentThread().getName(), i);
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}

public class ClassicThread {
    public static void main(String[] args) {
        Thread ts[] = { new Looper("L1"), //
                new Thread(new Runner(), "R1"), //
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 3; i++) {
                            try {
                                System.out.printf("%s: simulation %d%n", Thread.currentThread().getName(), i);
                                Thread.sleep((long) (Math.random() * 1_000));
                            } catch (InterruptedException e) {
                                throw new IllegalStateException(e);
                            }
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
