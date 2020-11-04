package com.shareforever.intvwdemo.datastructure.string;


/**
 * https://www.geeksforgeeks.org/find-the-last-non-repeating-character-in-string/
 * Input: str = "GeeksForGeeks"
 * output: r
 * <p>
 * Input: str = " abccba"
 * output: -1
 */
public class FindLastNonRepeatingCharacters {
    public static void main(String... args) {
        String str = "uabccdaxxyzblz";

        System.out.println(solution(str));
    }

    public static String solution(String s) {
        if (s == null || s.length() == 0) return "-1";
        System.out.println(s.repeat(2));

        for (int i = s.length() - 1; i > 0; i--) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return s.charAt(i) + "";
            }
        }

        return "-1";
    }
}
