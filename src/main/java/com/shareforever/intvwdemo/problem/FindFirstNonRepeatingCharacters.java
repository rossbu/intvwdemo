package com.shareforever.intvwdemo.problem;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=5co5Gvp_-S0
 * <p>
 * find the first Non-repeating char in the array
 * input = "asfjalfsad' return "j"
 * input = "aaaaa"  return "_"
 * input = "abcde"  return "_"
 * input = "";
 */
public class FindFirstNonRepeatingCharacters {
    public static void main(String[] args) {
        String str = "azbcdeedcba";
//        System.out.println(bruteforce(str));
//        System.out.println(betterForce(str));
//        System.out.println(bestForce(str));
        System.out.println(tryme(str));
    }

    private static char tryme(String s) {
       // put chars in map
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for ( int i = 0 ; i < s.length(); i++){
            char c  = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) +1);
        }

        // findFirst with value 1
        return map.entrySet().stream()
                .filter( e -> e.getValue() ==1)
                .findFirst()
                .get().getKey();
    }

    /*
        for ( o -N ){
            char c = chars[i]

        }

     */
    private static char bruteForce(String input) {
        char c = ' ';
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char[] tempChars = input.substring(0, i).concat(input.substring(i + 1)).toCharArray();
            boolean isDuplicateFound = false;
            for (int j = 0; j < tempChars.length; j++) {
                if (chars[i] == tempChars[j]) {
                    isDuplicateFound = true;
                    break;
                }
            }
            if (!isDuplicateFound) {
                c = chars[i];
                break;
            }
        }
        return c;
    }

    /**
     * TC: O(N^2)
     * SC: O(N)
     *
     * @param str
     * @return
     */
    private static char bruteforce(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean noRepeating = true;
            for (int j = 0; j < str.length(); j++) {

                // ignore itself
                if (i == j) {
                    continue;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    noRepeating = false;
                    break;
                }
            }
            if (noRepeating) {
                return str.charAt(i);
            }
        }
        return '_';
    }

    public static char betterForce(String s) {
        char[] r = new char[1];

        // put everything in linkedHashMap [char, frequency]
        Map<Character, Integer> m = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
            } else {
                m.put(s.charAt(i), 1);
            }
        }

        // find the first pair ( key - value) with value 1
        m.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .ifPresentOrElse((e) -> r[0] = e.getKey(), () -> r[0] = '_');

        return r[0];
    }

    private static char bestForce(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                return str.charAt(i);
            }
        }
        return '_';
    }


}
