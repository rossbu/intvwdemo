package com.shareforever.intvwdemo.datastructure.string;


/**
 * leetcode - 214 shortest palindrome
 * https://leetcode.com/problems/shortest-palindrome/
 * <p>
 * longest palindrome
 * https://www.youtube.com/watch?v=0CKUjDcUYYA&t=554s
 */
public class Plalindrome {

    public static void main(String[] args) {

        // isPalindrome
        String str = "anna1ABASDFDAS12121";
        String str1 = "abccbadood1213r4";
        System.out.println(isPlaindrome2(str1));

        // longest palindrome
        System.out.println(longestPalindrome(str));

        // return shortest palindrome
        System.out.println(shortestPalindrome(str));
    }


    /**
     * babad  : brute force
     * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/?ref=lbp
     * outter: b -> d
     * e.g.
     * b
     * ba
     * bab
     * baba
     * babad
     * <p>
     * a
     * ab
     * aba
     * abad
     *
     * @param str
     * @return
     */
    private static String longestPalindrome(String str) {
        return "";
    }

    /*
        charAt returns primitive char type, so use == instead of equals which is yet for Object comparison
     */
    private static boolean isPlaindrome2(String string) {
        if (string == null || "".equals(string)) return false;
        for (int i = 0, j = string.length() - 1; i <= j; i++, j--) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public static String shortestPalindrome(String str) {

        int x = 0;
        int y = str.length() - 1;

        while (y >= 0) {
            if (str.charAt(x) == str.charAt(y)) {
                x++;
            }
            y--;
        }

        if (x == str.length())
            return str;

        String suffix = str.substring(x);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(str.substring(0, x));

        return prefix + mid + suffix;
    }

    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
