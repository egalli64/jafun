package com.example.jfp.s06;

public class MemberClosure {
    private static String[] months = { //
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "N/A" //
    };

    public static MonthName closure() {
        return i -> (i > 0 && i < months.length) ? months[i - 1] : months[months.length - 1];
    }

    public static void setOutOfBound(String msg) {
        months[months.length - 1] = msg;
    }
}
