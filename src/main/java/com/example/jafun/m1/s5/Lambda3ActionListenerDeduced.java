/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lambda syntax
 */
public class Lambda3ActionListenerDeduced {
    /**
     * Defining an ActionListener lambda - leaving type deduction to the compiler
     * <p>
     * Print the passed ActionEvent
     */
    public static void main(String[] args) {
        System.out.println("A deduced ActionListener\n");
        ActionListener lambda = e -> System.out.println(e);

        lambda.actionPerformed(new ActionEvent(new Object(), 42, "Hello"));
    }
}
