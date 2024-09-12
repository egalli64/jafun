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
public class Lambda2ActionListener {
    /**
     * Defining an ActionListener lambda
     * <p>
     * Print the passed ActionEvent
     */
    public static void main(String[] args) {
        System.out.println("An ActionEvent -> void");
        ActionListener lambda = (ActionEvent e) -> {
            System.out.println(e);
        };

        lambda.actionPerformed(new ActionEvent(new Object(), 42, "Hello"));
    }
}
