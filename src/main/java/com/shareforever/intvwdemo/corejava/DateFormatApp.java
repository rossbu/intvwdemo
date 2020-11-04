package com.shareforever.intvwdemo.corejava;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

class DateFormatApp {
    public static void main(String[] args) throws FileNotFoundException {
        LocalDate localDate = LocalDate.of(2015, 4, 4);
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("E, MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
    }
}

