package com.shareforever.intvwdemo.datastructure.string;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
  https://www.codeproject.com/Tips/1275693/Recursive-Permutations-in-Python
 '1234',
 '1243',
 '1324',
 '1342',
 '1423',
 '1432',
     '2134',
     '2143',
     '2314',
     '2341',
     '2413',
     '2431',
         '3124',
         '3142',
         '3214',
         '3241',
         '3412',
         '3421',
             '4123',
             '4132',
             '4213',
             '4231',
             '4312',
             '4321'
 */
public class Permutation {
    static HashSet set = new HashSet();

    public static void main(String[] args) {
        String s = "XYZ";
        permutation(s, "");
        System.out.println("----------- use HashSet to store and return -----------");
//        Set set = permutation2(s);
//        set.stream().forEach(System.out::println);
        perm(s, "");
    }

    public static void perm(String s, String output) {
        if (s.length() == 0) {
            System.out.println(output);
        }

        // exit condition

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String r = s.substring(0, i) + s.substring(i + 1);
            perm(r, output + c);

        }
    }


    // quick output
    public static void permutation(String s, String str) {
        if (s == null || s.length() == 0) {
            System.out.println(str);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String rest = s.substring(0, i) + s.substring(i + 1);
            permutation(rest, str + c);
        }
    }

    public static Set<String> permutation2(String str) {
        Set<String> perm = new LinkedHashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        } else {
//            System.out.println(str);
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // rest of string
        Set<String> words = permutation2(rem);
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
}
