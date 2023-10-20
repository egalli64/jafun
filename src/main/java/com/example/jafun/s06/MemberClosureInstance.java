/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafun.s06;

/**
 * A class providing instance-level context to a lambda to make it a closure
 */
public class MemberClosureInstance {
    private String[] months = { //
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "N/A" //
    };

    /**
     * An instance field is used by the returned lambda. A Java closure is allowed
     * to modify a captured data member (but not a local variable)
     * 
     * @return a closure
     */
    public MonthName closure() {
        return i -> {
            months[months.length - 1] += "x";
            return (i > 0 && i < months.length) ? months[i - 1] : months[months.length - 1];
        };
    }

    /**
     * Field setter, notice that the field is used by the closure
     * 
     * @param msg a new message in case of out of bound access to months
     */
    public void setOutOfBound(String msg) {
        months[months.length - 1] = msg;
    }
}
