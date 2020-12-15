package com.shareforever.intvwdemo.corejava.date;

import java.time.*;

interface MonthDayHelper {
    default MonthDay construct(Month month, int dayOfMonth) {
        return MonthDay.of(month, dayOfMonth);
    }

    static String toString(MonthDay monthDay) {
        return monthDay.getMonth().toString() + " " + monthDay.getDayOfMonth();
    }
}

interface LocalTimeHelper {
    default LocalTime construct(int hour, int minute, int second) {
        return LocalTime.of(hour, minute, second);
    }

    static String toString(LocalTime localTime) {
        return localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond();
    }
}

public class DateTimeClass implements MonthDayHelper, LocalTimeHelper {
    private MonthDay monthDay;
    private LocalTime localTime;

    DateTimeClass(Month month, int dayOfMonth, int hours, int minutes, int seconds) {
//        monthDay = MonthDayHelper.super.construct(month,dayOfMonth);
//        localTime = LocalTimeHelper.super.construct(hours,minutes,seconds);
    }

    void print() {
//        **2**
        System.out.print(MonthDayHelper.toString(monthDay));
        System.out.println(" " + LocalTimeHelper.toString(localTime));

    }

    public static void main(String[] args) {
        DateTimeClass dt1 = new DateTimeClass(Month.OCTOBER, 31, 12, 5, 30);
        DateTimeClass dt2 = new DateTimeClass(Month.JANUARY, 1, 5, 14, 25);
        dt1.print();
        dt2.print();

        System.out.println("Current JVM Heap Size:" + Runtime.getRuntime().totalMemory());
        System.out.println("Maximum JVM Heap Size:" + Runtime.getRuntime().maxMemory());
        System.out.println("Free JVM Heap Size:" + Runtime.getRuntime().freeMemory());

//        TimeZone tz = TimeZone.getGMTTimeZone();
        ZoneOffset zo = ZoneOffset.of("00:00");
        System.setProperty("user.timezone", "UTC");
    }
}
