package com.shareforever.intvwdemo.corejava;

import java.util.*;

public class StringFormatTest {
    public static void main(String[] args) {
        String stringA = "A";
        String stringB = "B";
        String stringnull = null;
        StringBuilder builder = new StringBuilder("C");
        Formatter fmt = new Formatter(builder);

        fmt.format("%s%s", stringA, stringB);
        System.out.println("Line 1: " + fmt);

        fmt.format("%-2s", stringB);
        System.out.println("Line 2: " + fmt);

        fmt.format("%b", stringnull);
        System.out.println("Line 3: " + fmt);


        String name = "sonoo";
        String sf1 = String.format("name is %b %s %c", null, null, 'a');
        System.out.println("Line 4:" + sf1);
    }
}
