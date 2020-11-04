package com.shareforever.intvwdemo.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class RegxString {


    /*
        \d+ : matches one or more digits
        \D+ : matches one or more non-digits
        \s+ : matches one or more whitespaces or tabs
        \S+ : matches one or more non-whitespaces

        . : match any characters
        * : {0,} : 0 or more times  e.g   X* finds no or several letter X
        ? : {0,1} : 0 or 1 time  e.g  X? find one X or NO


     */
    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        String str1 = "abc   123      c    456  ";
        System.out.println(str1.replaceAll("\\D+", ""));
        Thread.sleep(1000);
        long end = System.nanoTime();
        System.out.println("time elapsed: " + (end - start) / 1_000_000_000 + "s"); //1 second = 1_000_000_000 nanosecond

        System.out.println(str1.replaceAll("\\s+", ""));
        Arrays.stream(str1.split("\\s+")).forEach(System.out::println);

        String names = "alex,brian,charles,david";
        Pattern p = Pattern.compile(",");
        Arrays.asList(p.split(names)).forEach(System.out::println);


        names.toCharArray();
        System.out.println(String.valueOf(names.toCharArray()));
    }


}
