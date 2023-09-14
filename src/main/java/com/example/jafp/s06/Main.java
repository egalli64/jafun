package com.example.jafp.s06;

public class Main {
    private static void local() {
        System.out.println("Using a closure on a local variable");
        MonthName monthName = LocalClosure.closure();

        System.out.println(monthName.asString(0));
        System.out.println(monthName.asString(1));
        System.out.println(monthName.asString(3));
        System.out.println(monthName.asString(12));
        System.out.println(monthName.asString(13));
    }

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

    private static MonthName memberInstance() {
        MemberClosureInstance mci = new MemberClosureInstance();

        mci.setOutOfBound("Bad month");

        return mci.closure();
    }

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
