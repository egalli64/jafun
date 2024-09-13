/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m2.s2;

/**
 * A class providing class-level context to a lambda to make it a closure
 */
public class MemberClosure {
    private static String[] months = { //
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "N/A" //
    };

    /**
     * A class field is used by the returned lambda
     * 
     * @return a closure
     */
    public static MonthName closure() {
        return i -> (i > 0 && i < months.length) ? months[i - 1] : months[months.length - 1];
    }

    /**
     * Field setter, notice that the field is used by the closure
     * 
     * @param msg a new message in case of out of bound access to months
     */
    public static void setOutOfBound(String msg) {
        months[months.length - 1] = msg;
    }
}
