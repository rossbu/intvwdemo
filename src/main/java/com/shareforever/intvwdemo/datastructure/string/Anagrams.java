package com.shareforever.intvwdemo.datastructure.string;


import java.util.Arrays;

/*
 * Anagram:
    An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, ignoring space, punctuation, and capitalization.
    typically using all the original letters exactly once

    example:
      Mary  - Army
      cinema  -  iceman  - Iceman - Cinema.
      Two strings are anagrams

    hint:  1, Arrays  2, Loop
 */
public class Anagrams {

    public static void main(String[] args) {
        String a = "cinema";
        String b = "iceman1";


        // use Sorting
        System.out.println(checkAnagram(a, b));


        // use dict
        System.out.println(isAnagram(a, b));
    }

    /*
        use dictionary ASCII 256 int[] to mark +1 or -1 , so should be balanced.
    */
    private static boolean isAnagram(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;
        int len = a.length();
        int[] asciis = new int[256];
        while (len-- > 0) {
            asciis[a.charAt(len)]++;
            asciis[b.charAt(len)]--;
        }
        for (int c : asciis) {
            if (c != 0) return false;
        }

        return true;
    }

    private static boolean checkAnagram(String fst, String sec) {
        char[] fstChars = fst.toLowerCase().toCharArray();
        char[] secChars = sec.toLowerCase().toCharArray();
        Arrays.sort(fstChars); // nature order ( hash of each char)
        Arrays.sort(secChars);
        return Arrays.equals(fstChars, secChars);
    }
}
