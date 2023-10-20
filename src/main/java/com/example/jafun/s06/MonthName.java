/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafun.s06;

/**
 * An interface meant to be used in FP context
 */
@FunctionalInterface
interface MonthName {
    String asString(int month);
}
