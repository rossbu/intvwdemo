package com.shareforever.intvwdemo.datastructure.string;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
https://www.geeksforgeeks.org/array-rotation/
 */
public class RotateLeftRight {
    public static void main(String[] args) {

        // String rotate
        String s = "iamacat";
        rotateLeft(s, 8);
        rotateRight(s, 8);

        // Wrong impl
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        // this moves by binary value, not by position, don't use it wrongly
        // int i = Integer.rotateLeft(1234, 1); // wrong!!!

        // collection rotate
        rotateByCollections(arr);


    }

    private static void rotateByCollections(int[] arr) {
        IntStream.of(arr).mapToObj(e -> e).collect(Collectors.toList());
    }

    private static String rotateLeft(String s, int shifts) {
        if (shifts > s.length())
            shifts = shifts % s.length();
        System.out.println(s.substring(shifts) + s.substring(0, shifts));
        return s.substring(shifts) + s.substring(0, shifts);
    }


    private static String rotateRight(String s, int shifts) {
        if (shifts > s.length())
            shifts = shifts % s.length();
        System.out.printf(s.substring(s.length() - shifts) + s.substring(0, s.length() - shifts));
        return s.substring(s.length() - shifts) + s.substring(0, s.length() - shifts);
    }

}
