package com.shareforever.intvwdemo.datastructure.string;

import java.util.ArrayList;
import java.util.List;

public class SubString {
    public static void main(String[] args) {
        // Find all substrings of a String in java
        String allString = "abcd";
        findAllSubString(allString);
        System.out.println();
    }

    private static void findAllSubString(String allString) {
        List<String> subStrings = new ArrayList<String>();
        for (int i = 0; i < allString.length(); i++) {
            for (int j = i + 1; j <= allString.length(); j++) {
                subStrings.add(allString.substring(i, j));
            }
        }
        subStrings.forEach(System.out::println);
    }
}
