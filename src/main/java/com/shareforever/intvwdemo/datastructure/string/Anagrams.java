package com.shareforever.intvwdemo.datastructure.string;


import java.util.Arrays;

/*
 * Anagram:
    An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, ignoring space, punctuation, and capitalization.
    typically using all the original letters exactly once

    example:
      Mary  - Army
      cinema  -  iceman  - Iceman - Cinema
      Two strings are anagrams

      hint:  1, Arrays  2, Loop
 */
public class Anagrams {

    public static void main(String[] args) {
        String a = "cine  ma";
        String b = "icemaN??!";

        // ^ appears as the first character inside square brackets, it negates the pattern
        System.out.println("abc .&edf?".replaceAll("\\W+",""));
        System.out.println("icemaN??!".toLowerCase().replaceAll("[^\\w+]",""));
        // use Sorting
        System.out.println(checkAnagram(a, b));

        // use dict
        System.out.println(isAnagram(a, b));

        System.out.println(solution(a,b+" "));
    }

    static boolean solution(String s1, String s2){
        // remove space , punctuation, Captilization
        char[] s1chars = s1.toLowerCase().replaceAll("[^w+]","").toCharArray();
        char[] s2chars = s2.toLowerCase().replaceAll("[^w+]","").toCharArray();

        Arrays.sort(s1chars);
        Arrays.sort(s2chars);

        return Arrays.equals(s1chars,s2chars);
    }

    /*
        use dictionary ASCII 256 int[] to mark +1 or -1 , so should be balanced.
    */
    private static boolean isAnagram(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;
        int len = a.length();
        int[] asciis = new int[256];
        while (len--> 0) {
            asciis[a.charAt(len)]++;
            asciis[b.charAt(len)]--;
        }
        for (int c : asciis) {
            if (c != 0) return false;
        }

        return true;
    }

    private static boolean checkAnagram(String s1, String s2) {
        // remove space , punctuation, Captilization
        char[] s1chars = s1.toLowerCase().replaceAll("[^\\w+]","").toCharArray();
        char[] s2chars = s2.toLowerCase().replaceAll("[^\\w+]","").toCharArray();

        Arrays.sort(s1chars); // nature order ( hash of each char)
        Arrays.sort(s2chars);
        return Arrays.equals(s1chars, s2chars);
    }
}
