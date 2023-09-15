/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafp.s06;

/**
 * Closure use examples
 */
public class Main {
    /**
     * Store a closure in a local variable, then use it
     */
    private static void local() {
        System.out.println("Using a closure on a local variable");
        MonthName monthName = LocalClosure.closure();

        System.out.println(monthName.asString(0));
        System.out.println(monthName.asString(1));
        System.out.println(monthName.asString(3));
        System.out.println(monthName.asString(12));
        System.out.println(monthName.asString(13));
    }

    /**
     * Get a closure enclosing data member from another class, then use it. Notice
     * that the closure is changed while used.
     */
    private static void member() {
        System.out.println("Using a closure on a member variable");
        MonthName monthName = MemberClosure.closure();

        System.out.println(monthName.asString(0));
        System.out.println(monthName.asString(1));
        System.out.println(monthName.asString(3));
        System.out.println(monthName.asString(12));
        System.out.println(monthName.asString(13));

        MemberClosure.setOutOfBound("Not Available");
        System.out.println("After changing the captured data member");

        System.out.println(monthName.asString(0));
        System.out.println(monthName.asString(1));
        System.out.println(monthName.asString(3));
        System.out.println(monthName.asString(12));
        System.out.println(monthName.asString(13));
    }

    /**
     * Store in a local variable an object containing a closure
     * 
     * @return a closure
     */
    private static MonthName memberInstance() {
        MemberClosureInstance mci = new MemberClosureInstance();

        mci.setOutOfBound("Bad month");

        return mci.closure();
    }

    /**
     * Use some different closures
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        local();
        member();

        System.out.println("Using a closure on a member variable");
        MonthName mn = memberInstance();

        System.out.println(mn.asString(0));
        System.out.println(mn.asString(1));
        System.out.println(mn.asString(3));
        System.out.println(mn.asString(12));
        System.out.println(mn.asString(13));
    }
}
