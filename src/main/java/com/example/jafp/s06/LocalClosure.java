/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafp.s06;

/**
 * A class providing local context to a lambda to make it a closure
 */
public class LocalClosure {
    /**
     * A local variable (effectively constant) is used by the returned lambda
     * 
     * @return a closure
     */
    public static MonthName closure() {
        String[] months = { //
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "N/A" //
        };

        return i -> (i > 0 && i < months.length) ? months[i - 1] : months[months.length - 1];
    }
}
