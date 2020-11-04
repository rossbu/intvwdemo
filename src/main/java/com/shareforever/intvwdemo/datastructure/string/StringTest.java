package com.shareforever.intvwdemo.datastructure.string;


import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * String,  StringBuilder , StringBuffer
 * <p>
 * String is immutable whereas
 * StringBuffer and StringBuilder are mutable classes.
 * StringBuffer is thread-safe and synchronized , whereas StringBuilder is not
 * <p>
 * aka : buffer is safer.  builder is faster.
 */
public class StringTest {

    public static void main(String[] args) {
        String test = "xyz";
        String ans = reverseRecursive(test);
        System.out.println(ans);

        // isSubstring
        isSubString();

        // isRotated
        System.out.println("lewaterbott rotated ? " + isRotated("waterbottle", "lewaterbott"));
        isStringRotated("waterbottle", "lewaterbott");

        // remvoe dups from unsorted linkedList
        LinkedList linkedList = new LinkedList();


        // be alert == on constant pool pointer.  and new String for new object.
        equals();

        // String valueOf == copyValueOf  == new String   then s.toCharArray()  returns any array of char[] again.
        valueOf();

        // char <-> int conversion
        charToInt();

        // reference or primitive type or Object
        referenceOrPrimitive();

        // is All unique in string
        System.out.println(isAllUnique("12344"));

        // is all Same in String
        System.out.println(isAllSame("aaaa"));

        // reverse a C-style string  , not sure what is this
        System.out.println(reverse("this is a demo!"));

        //
        removeDuplicateByHashing("abbccdde1233");
        removeDuplicateCharToStringThenCollect("abbccdde1233");
        removeDuplicateWithoutExtraSpace("abbccdde1233");
        deleteDuplicateAndKeepOrderWithFirstOccurrence("778899aabbcc");  // most efficient way
    }

    private static boolean isRotated(String s1, String s2) {
        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }

    /*
    Bruteforce.
     */
    static boolean isStringRotated(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return false;
        if (s1.length() != s2.length()) return false;
        int s1len = s1.length();
        // rotate char to the right by 1 to n
        while (s1len-- > 0) {
            String rotated = s1.substring(s1len) + s1.substring(0, s1len);
            System.out.println(rotated);
            if (rotated.equals(s2)) {
                return true;
            }
        }
        return false;
    }

    private static void isSubString() {
        boolean isSubString = "Iamfine".indexOf("fine") != -1 ? true : false;
        boolean isSubString2 = "Iamfine".lastIndexOf("fine") != -1 ? true : false;
        boolean isSubString3 = "Iamfine".contains("fine1");
        System.out.println("" + isSubString + isSubString2 + isSubString3);
    }


    public static String reverseRecursive(String s) {
        if (s.length() == 0) return "";
        if (s == "") return "";  // tricky here if you use subString you can't use ==,  subString uses new String();
        String reversed = reverseRecursive(s.substring(1));
        return reversed + s.charAt(0);
    }


    static void deleteDuplicateAndKeepOrderWithFirstOccurrence(String input) {
        if (input == null || input.length() <= 1) return;

        String output = "";
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (output.indexOf(chars[i]) < 0) {
                output += chars[i];
            }
        }
        System.out.println("after deletion of first occurrence: " + output);

    }

    static String removeDuplicateByHashing(String s) {
        if (s == null || s.length() <= 1) return s;
        LinkedHashSet<Character> set = new LinkedHashSet<Character>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (set.add(c))
                sb.append(c);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    /*
        remove duplicate chars from String s
     */
    private static void removeDuplicateCharToStringThenCollect(String s) {
        String ans1 = s.chars().distinct().mapToObj(e -> (char) e).map(String::valueOf).collect(Collectors.joining(""));
        String ans2 = s.chars().distinct().mapToObj(c -> Character.valueOf((char) c)).map(String::valueOf).collect(Collectors.joining(""));
        String ans3 = s.chars().boxed().distinct().map(e -> (char) e.intValue()).map(String::valueOf).collect(Collectors.joining(""));
        System.out.println(ans1);
    }

    /*
      3 pointers to solve.
      i : iterate thru all chars
      j : check previous ( before i ) elements if it exists or not,
          when j == i  , it means, didn't find new char. so new array++ and put new char
          when j < i, it means it breaks in the middle when same i is found
      n : means news. use same array to store unique value from 0
    */
    static String removeDuplicateWithoutExtraSpace(String s) {
        char[] arr = s.toCharArray();
        if (s == null || s.length() <= 1) return s;
        String ans = "";
        int len = arr.length;
        int n = 0; // new pointer for 'newold array'
        for (int i = 0; i < len; i++) {
            int j; // 2 conditoins , found or not found
            for (j = 0; j < i; j++) {
                if (arr[j] == arr[i]) { // found
                    break; // now j < i
                }
            }
            if (j < i) continue;

            if (j == i) { // not found
                arr[n++] = arr[i];
            }
        }
        ans = String.valueOf(arr).substring(0, n);
        return ans;
    }


    public static String reverse(String input) {
        char[] data = input.toCharArray();
        int i = 0;
        int j = data.length - 1;
        char temp;
        while (i < j) {
            temp = data[i];
            data[i] = data[j];
            data[j] = temp;
            i++;
            j--;
        }

        String s = new String(data);
        System.out.println(input.length() + " vs " + s.length());
        return s;
    }

    /*
        BF
        Stream allMatch
     */
    private static boolean isAllSame(String s) {
        if (s == null) return true;
        return s.chars().allMatch(c -> c == s.charAt(0));
    }

    /*
        BF
        TC : O(n^2)
        SC : O(n)
        https://www.geeksforgeeks.org/determine-string-unique-characters/
        4 ways:
            2 loops
            dict 256 only       Arrays.fill(arr, false)
            adjacent values after soring  Arrays.sort(arr)
            Stream and group
     */
    private static boolean isAllUnique(String s) {
        if (s == null) return true;
        return !s.chars().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .anyMatch(entry -> entry.getValue() > 1);
    }

    private static void valueOf() {
        System.out.println("String valueOf Test");
        char[] chars1 = {'a', 'a', 'a', 'a'};
        char[] chars2 = {'a', 'a', 'a', 'a'};
        char[] chars3 = {'a', 'a', 'a', 'a'};

        String s = String.valueOf(chars1) + String.copyValueOf(chars2) + new String(chars3);
        char[] chars4 = s.toCharArray();
        System.out.println(String.valueOf(chars4));
        System.out.println("same?:" + s.chars().allMatch(c -> c == s.charAt(0)));
    }

    private static void referenceOrPrimitive() {
        String str = "nochange";
        int i = 0;
        MySuper object = new MySuper();
        changeMe(i, str, object);
        System.out.println(i);
        System.out.println(str);
        System.out.println(object.name);
    }

    private static void charToInt() {
        int a = Character.getNumericValue('a');
        int b = 'a';
        char c = 'a';
        char d = 97;
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        System.out.println("c : " + (int) c);
        System.out.println("d : " + d);
        System.out.println("d==b?: " + (d == b));
        System.out.println("c+d : " + (c + d));
    }

    static void equalsSub(String s) {
        System.out.println(s.length());
        System.out.println(s == "");
    }

    private static void equals() {
        System.out.println("String equals and == Test");
        // != or = is used for reference pointer Comparison
        // Constant pool is fixed. e points to address in constant pool in heap
        String e = "ABC";
        String d = "";

        System.out.println("" == d);
        equalsSub(d);
        System.out.println((e == "ABC") ? "true" : "false");
        System.out.println((e.equals("ABC")) ? "true" : "false");
        System.out.println((e == new String("ABC")) ? "true" : "false");
        System.out.println("\t");

        // new String in regular heap space, as other objects.
        String x = new String("1");
        System.out.println((x == "1") ? "true" : "false");
        System.out.println((x.equals("1")) ? "true" : "false");
        System.out.println((x == new String("1")) ? "true" : "false");
        System.out.println((new String("1") == new String("1")) ? "true" : "false");  // this is false. Wow
    }

    public static void changeMe(int i, String s, MySuper mysuper) {
        i++;
        s = s.substring(0, 1);
        mysuper.name = "nameChanged";
        System.out.println("i=" + i);
        System.out.println("s=" + s);
        System.out.println("mysuper.name=" + mysuper.name);

    }

    private static class MySuper {
        public String name = "noChange";

        protected String buildString(String current) {
            return current + 1;
        }
    }

    private static class MySub extends MySuper {
        @Override
        public String buildString(String current) {
            return super.buildString(current);
        }
    }
}


