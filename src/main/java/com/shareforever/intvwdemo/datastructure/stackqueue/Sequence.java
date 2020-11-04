package com.shareforever.intvwdemo.datastructure.stackqueue;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Given a string, we have to find out all subsequences of it.
 * Input : abc
 * Output : a, b, c, ab, bc, ac, abc
 * <p>
 * Input : aaa
 * Output : a, aa, aaa
 */
public class Sequence {
    public static ArrayList<String> al = new ArrayList<String>();

    public static void main(String[] args) {

        String arr = "abc";

        solution(arr);

    }

    private static void solution(String arr) {
        Set set = new HashSet<String>();
        for (int i = 0; i < arr.length(); i++) {
            char c = arr.charAt(i);
            set.add(c);

        }
        // print all
        Stream.of(set).forEach(System.out::println);
    }
}
