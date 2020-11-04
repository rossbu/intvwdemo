package com.shareforever.intvwdemo.datastructure.string;

public class Reversal {

    public static void main(String[] args) {
        String input = "practice makes perfect";
//        String result = bruteforce(input);   // swap elements from both ends
//        String result = betterforce(input);  // use StringBuidler api to reverse
//        String result = iterative(input);    // loop reversely
        String result = recursive(input);     // smart recursive , call itself N times ( where N is the length of string )
        System.out.println(result);
    }

    private static String recur(String input) {
        return recur(input.substring(1) + input.charAt(0));
    }

    private static String recursive(String input) {
        if (input.length() < 2) return "";
        return recursive(input.substring(1)) + input.charAt(0);
    }

    private static String iterative(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private static String easyForce(String input) {
        StringBuffer reverse = new StringBuffer(input).reverse();
        return reverse.toString();
//        return new StringBuffer(input).reverse().toString();
    }

    private static String bruteforceByJustSwap(String input) {
        char[] chars = input.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
        return new String(chars); // do NOT use Arrays.toStrng(s), which has brackets and comma in there.
    }
}
