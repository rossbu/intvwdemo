package com.shareforever.intvwdemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WarmUp {
    public static void main(String[] args) {
        // testcases
        String[] testcases = new String[]{"abcd", null, "", "aaaa", "abcaaa","a","abc"};
        int[] testcasesInt = new int[]{Integer.MIN_VALUE,1,555,Integer.MAX_VALUE};
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------ LET'S WARM UP ---------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");

        // is num has a square foot
        System.out.println("num 4: " + isSquare(4));

        // given 456789, need to print 101010
        String result11 = evenOneOddZero(5);
        System.out.println("evenOneOddZero : " + result11);

        // int[] to Integer[] ,  Integer[] to int[]
        int[] arr2 = new int[]{54, 432, 53, 21, 43, 12, 45, 11, 10, 9};
        int[] sameArr2 = intToIntegerThenToInt(arr2);

        // isAllSame
        for (String s : testcases) {
            boolean isUnique = isAllSame(s);
            System.out.println(s + " : " + isUnique);
        }

        // isAllUnique
        for (String s : testcases) {
            boolean isUnique = isAllUnique(s);
            System.out.println(s + " : " + isUnique);
        }

        // fizzbuzz  -- warmup your fingers =  divisible by 3 fizz, divisible by 5 : fuzz,  divisible by 3 and 5 then fizzbuzz
        fizzbuzz();

        // Fibonacci  0,1,1,2,3,5,8... -- PUB -- fib(0) = 0, fib(1) = 1, fib(2) = 1
        int result = fibRecursive(10);
        System.out.println("fib:" + result);

        // Fibonacci Recursive  3 vars :  PP, P, C  ( prevprev, prev and current in for loop)
        result = fibIterative(10);
        System.out.println("fibRecurisve:" + result);

        // factorial  5*4*3*2*1
        int factorial = factorial(6);
        factorial = factorialIterative(6);
        System.out.println("factorial:" + factorial);

        // reverse xyzu to uzyx with recursive method -- PUB
        String test = "xyzu";
        String teststr = reverse(test);
        System.out.println("reverse:" + teststr);

        // reverse int[] array
        int[] arr3 = new int[]{54, 432, 53, 21, 43, 12, 45, 11, 10, 9};
        reverseIntArray(arr3);

        // reverse int value like 12345  to 54321 without using array
        int originalInt = 1234;
        int reversedNumber = reverseIntNumber(originalInt);

        // reverse a number recursively
        int ans = 0;
        ans =  reverseIntNumberRecursively(originalInt,ans);
        System.out.println(ans);


    }
    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1.0d == 0.0d;
    }

    public static String evenOneOddZero(int num) {
        String result = "";
        for (int i = 0; i < num; i++) {
            result += i % 2 == 0 ? "1" : "0";
        }
        return result;
    }

    private static void fizzbuzz() {
        IntStream.rangeClosed(1, 100).boxed()
                .forEachOrdered(
                        e -> {
                            if (e % 3 == 0 && e % 5 == 0) {
                                System.out.println("fizzbuzz");
                            } else if (e % 3 == 0) {
                                System.out.println("fizz");
                            } else if (e % 5 == 0) {
                                System.out.println("buzz");
                            } else {
                                System.out.println(e);
                            }
                        }
                );
    }

    private static boolean isAllUnique(String s) {
        if (s == null || s.length() <= 1) return false;
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean isUnique = false;

        // M0: ask interviewer should I use stream
        isUnique = s.chars().distinct().count() == s.length();

        // M1: hashing check length
        HashSet<Character> set = new HashSet<Character>();
        for (char c : chars)
            set.add(c);
        isUnique = len == set.size() ? true : false;





        // M3
        Map<Integer, Long> map = s.chars().boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        boolean notUnique = map.entrySet().stream().anyMatch(e -> e.getValue() > 1);
        System.out.println(s + " isAllUnique ? " + !notUnique);

        return isUnique;
    }

    private static boolean isAllSame(String s) {


        // M1 , check if all match the first one or last one
        boolean isSame = s.chars().allMatch(c -> c == s.charAt(0));


        // M2: check if disinct and count equals 1
        isSame = s.chars().distinct().count() == 1 ? true : false;

        // M3: Hashing, then the set size should be 1
        HashSet<Character> characters = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            characters.add(c);
        }

        // M4 : one line hashsert
        s.chars().forEach( c -> characters.add((char)c));
        isSame = characters.size() == 1 ? true : false;

        // M5: use codePoint
        int allPoints = s.charAt(0) * s.length();
        for (char c : s.toCharArray()) {
            allPoints -= (int) c;
        }
        isSame = allPoints == 0 ? true : false;
        return isSame;
    }

    /*
        Modding (%) the input int by 10 will extract off the rightmost digit. example: (1234 % 10) = 4
        Multiplying an integer by 10 will "push it left" exposing a zero to the right of that number, example: (4 * 10) = 40, then 400, 4000
        Dividing an integer by 10 will remove the rightmost digit. (1234 / 10) = 123

        steps
        a. Extract off the rightmost digit of your input number. (1234 % 10) = 4
        b. Take that digit (4) and add it into a new reversedNum.
        c. Multiply reversedNum by 10 (4 * 10) = 40, this exposes a zero to the right of your (4).
        d. Divide the input by 10, (removing the rightmost digit). (1234 / 10) = 123
        e. Repeat at step a with 123
     */
    private static int reverseIntNumber(int originalInt) {

        // so if argument is a string, you need to think more carefully it's it's overflown for int,
        // so use long would be better or ask interviewer for that aquesiton.  use Long or Int
        // try do while instead of while , same
        int reversedNum = 0;
        while (originalInt != 0) {
            reversedNum = reversedNum * 10;   // shift
            reversedNum = reversedNum + originalInt % 10;   // with extract off the right most number
            originalInt = originalInt / 10;   // remove the right most number off original one
        }
        System.out.println("reversed Int number : " + reversedNum);
        return reversedNum;
    }

    static int reverseIntNumberRecursively(int n, int ans){
        if ( n == 0) return ans;
        int remainder = n % 10;
        int quotient = n /10 ;
        ans = ans * 10 + remainder;
        return reverseIntNumberRecursively(quotient,ans); // when reaching the end, return 4 times in the stack from bottom to top and done.
    }

    private static void reverseIntArray(int[] arr) {
        System.out.println("------ reverse int [] ------- ");
//        // reverse
//        for ( int i=0 ; i< arr.length/2 ; i++){
//            int t = arr[i];
//            arr[i] = arr[arr.length-1-i];
//            arr[arr.length-1-i] = t;
//        }

        // much simpler if just to print it out
        int n = arr.length;
        while (n > 0) {
            System.out.print(arr[--n] + " ");
        }
        System.out.println();
    }


    private static int[] intToIntegerThenToInt(int[] arr) {
        return  IntStream.of(arr).mapToObj(Integer::valueOf).mapToInt(Integer::intValue).toArray();
//        return IntStream.of(arr).boxed().mapToInt(e -> e).toArray();
    }


    static int binarySearch(int[] arr, int left, int right, int n) {
        if (right > left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] > n) {
                return binarySearch(arr, left, mid - 1, n);
            } else if (arr[mid] < n) {
                return binarySearch(arr, mid + 1, right, n);
            }
        }
        return -1;
    }

    private static int fibIterative(int nTh) {
        int prevprev = 0;
        int prev = 0;
        int current = 1;
        for (int i = 1; i < nTh; i++) {
            prevprev = prev;
            prev = current;
            current = prevprev + prev;
        }
        return current;
    }


    public static void reverse(char[] chars) {
        int len = chars.length;

        // reverse all array
        swap(chars, 0, chars.length - 1);

        // reverse each word with space separator
        int start = 0;
        int end = 0;
        while (end < chars.length) {
            while (end < chars.length && chars[end] != ' ') {
                end++;
            }
            swap(chars, start, end - 1);
            end += 1;
            start = end;
        }

        // print
        System.out.println(String.valueOf(chars));
    }

    public static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }


    public static String reverse(String s) {
        if (s.length() == 0) return "";
        return reverse(s.substring(1)) + s.charAt(0);
    }


    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
    static int factorialIterative(int num){
        int product = 1;
        while ( num >=1) {
            product = product * num--;
        }
        return product;
    }

    public static int fibRecursive(int n) {
        if (n == 0) return 0;

        if (n == 1) return 1;

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

}
