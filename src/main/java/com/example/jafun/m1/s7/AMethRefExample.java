/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Method reference syntax example
 */
public class AMethRefExample {
    /**
     * Defining an ActionListener lambda by method reference
     * <p>
     * Invoke the println() method of System.out on the passed argument
     */
    public static void main(String[] args) {
        System.out.println("An ActionListener by method reference\n");
        ActionListener lambda = System.out::println;

        lambda.actionPerformed(new ActionEvent(new Object(), 42, "Hello"));
    }
}
