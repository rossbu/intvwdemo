package com.shareforever.intvwdemo.corejava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {
        Date aDate = null;
        try {
            aDate = new SimpleDateFormat("yyyy-MM-dd").parse("2012-01-15");  // should be MM
            Calendar aCalendar = Calendar.getInstance();
            aCalendar.setTime(aDate);
            System.out.print(aCalendar.get(aCalendar.DAY_OF_MONTH) + "," + aCalendar.get(aCalendar.MONTH));
        } catch (ParseException ex) {
            System.out.println(ex);
        }

        isLeapYear3(2009);
    }

    public static boolean isLeapYear(int year) {
        GregorianCalendar gc = new GregorianCalendar();
        return gc.isLeapYear(year);
    }


    public static boolean isLeapYear3(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        return (days > 365);
    }

    public boolean isLeapYear4(int year) {
        return Year.isLeap(year);
    }
}
