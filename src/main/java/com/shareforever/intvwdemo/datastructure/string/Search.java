package com.shareforever.intvwdemo.datastructure.string;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/check-if-given-words-are-present-in-a-string/?ref=leftbar-rightbar
 * Check if given words are present in a string
 * Input : bigString = "this is a big string", smallStrings = ["this", "yo", "is", "a", "bigger", "string", "kappa"]
 * Output : [true, false, true, true, false, true, false]
 * <p>
 * <p>
 * Note : that you can’t use language-built-in string-matching methods.
 */
public class Search {
    public static void main(String[] args) {

        String bigString = "this is a big string";
        String[] smallStrings = {"this", "yo", "is", "a", "bigger", "string", "kappa"};
        solution(bigString, smallStrings);
    }

    private static void solution(String bigString, String[] smallStrings) {
        Map<String, Boolean> m = new LinkedHashMap<String, Boolean>();
        for (int i = 0; i < smallStrings.length; i++) {
            if (bigString.contains(smallStrings[i])) { // A string is a CharSequence
                m.put(smallStrings[i], true);
            } else {
                m.put(smallStrings[i], false);
            }
        }
        Iterator<Map.Entry<String, Boolean>> iterator = m.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().getValue() + ",");
        }
    }


}
