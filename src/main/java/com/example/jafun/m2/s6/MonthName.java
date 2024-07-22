/*
 * Introduction to Functional Programming with Java
 * 
 * Module 2 - FP by lambda expression
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s6;

/**
 * An interface meant to be used in FP context
 */
@FunctionalInterface
interface MonthName {
    String asString(int month);
}
