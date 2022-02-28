package com.example.jfp.s06;

public class LocalClosure {
    public static MonthName closure() {
        String[] months = { //
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "N/A" //
        };

        return i -> (i > 0 && i < months.length) ? months[i - 1] : months[months.length - 1];
    }
}
