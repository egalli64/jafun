package com.example.jfp.s06;

public class MemberClosureInstance {
    private String[] months = { //
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "N/A" //
    };

    public MonthName closure() {
        return i -> {
            // a Java closure is allowed to modify a captured data member
            months[months.length - 1] += "x";
            return (i > 0 && i < months.length) ? months[i - 1] : months[months.length - 1];
        };
    }

    public void setOutOfBound(String msg) {
        months[months.length - 1] = msg;
    }
}
