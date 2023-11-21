package com.shareforever.intvwdemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WarmUp {
    public static void main(String[] args) {
        // testcases
        String[] testcases = new String[]{"abcd", null, "", "aaaa", "abcaaa","a","abc"};
        int[] testcasesInt = new int[]{Integer.MIN_VALUE,1,555,Integer.MAX_VALUE};
        System.out.println("------------------------------------------------------");
        System.out.println("------------------ LET'S WARM UP ---------------------");
        System.out.println("------------------------------------------------------");
        // is num has a square foot
        System.out.println("num 4 is squared? : " + isSquare(4));

        //  convert an integer to an array for each digit, for example:  123 -> [1,2,3]
        convertAnIntegerToAnArray(123);

        // convert int to array without using String or Integer methods
        intToArray(123456);

        // given any integer  such as 456789, print 1 if it is even, 0 if it is odd.
        evenOneOddZero(456789);


        // int[] to Integer[] ,  Integer[] to int[]
        int[] arr2 = new int[]{54, 432, 53, 21, 43, 12, 45, 11, 10, 9};
        intToIntegerThenToInt(arr2);

        System.out.println("\nisAllSame");
        for (String s : testcases) {
            boolean isUnique = isAllSame(s);
            System.out.println(s + " : " + isUnique);
        }

        System.out.println("isAllUnique");
        for (String s : testcases) {
            boolean isUnique = isAllUnique(s);
            System.out.println(s + " : " + isUnique);
        }


        // Fibonacci  0,1,1,2,3,5,8... -- PUB -- fib(0) = 0, fib(1) = 1, fib(2) = 1
        int result = fibRecursive(10);
        System.out.println("fibRecurisve: " + result);

        // Fibonacci Recursive  3 vars :  PP, P, C  ( prevprev, prev and current in for loop)
        result = fibIterative(10);
        System.out.println("fibInterative: " + result);

        // factorial  5*4*3*2*1
        int factorial = factorialRecursive(6);
        System.out.println("factorialRecursive:" + factorial);
        factorial = factorialIterative(6);
        System.out.println("factorialIterative:" + factorial);

        // reverse xyzu to uzyx with recursive method -- PUB
        String test = "xyzu";
        String teststr = reverseRecursively(test);
        String reversed = test.chars()
                .mapToObj(c -> (char)c)
                .reduce("", (s,c) -> c+s, (s1,s2) -> s2+s1);
        System.out.println("reverse:" + teststr);

        // reverse int[] array
        System.out.println("reverse an int Array");
        int[] arr3 = new int[]{54, 432, 53, 21, 43, 12, 45, 11, 10, 9};
        reverseIntArray(arr3);

        // reverse Iterativaly
        int originalInt = 1234;
        int reverseIterativeNumber = reverseIterative(originalInt);
        System.out.println("reverseIterativeNumber : " + reverseIterativeNumber);

        // reverse Recursively
        int reverseRecursiveInt = 12345;
        reverseRecursiveInt =  reverseRecursive(originalInt,reverseRecursiveInt);
        System.out.println("reverseRecursiveInt : " + reverseRecursiveInt);

    }

    private static void convertAnIntegerToAnArray(int i) {
    System.out.println("convertAnIntegerToAnArray");
        int [] arr = new int[String.valueOf(i).length()];
        String[] numStr = String.valueOf(i).split("");
        for ( int j = 0 ; j < numStr.length ; j++) {
            arr[j] = Integer.parseInt(numStr[j]);
            System.out.println(arr[j]);
        }
    }



    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1.0d == 0.0d;
    }


    /*
     given 12345, without using String or Integer methods, return array [1,2,3,4,5]
     temp 5  num 1234
     temp 4  num 123
     temp 3  num 12
     temp 2  num 1
     temp 1  num 0
     */
    static void intToArray(int num){
        if (num == 0 ) return;
        int temp = num % 10;
        num /= 10;
        intToArray(num);
    }


    public static void evenOneOddZero(int num) {
        String[] numStr = String.valueOf(num).split("");
        Stream.of(numStr).forEach(
            s -> {
                if (Integer.parseInt(s) % 2 == 0) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        );

//        String tmp = String.valueOf(num);
//        String[] tempstr = tmp.split("");
//        for ( String s : tempstr){
//            if ( Integer.valueOf(s) % 2 == 0 )
//                System.out.print("1");
//            else
//                System.out.print( "0");
//        }
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
        if (true)
            return s.chars().distinct().count() == s.length();

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

        if ( s == null || s.length() == 0 ) return true;

        // M1 , check if all match the first one or last one
        boolean isSame = s.chars().allMatch(c -> c == s.charAt(0));


        // M2: check if distinct and count equals 1
        isSame = s.chars().distinct().count() == 1 ? true : false;

        // M3: Hashing, then the set size should be 1
        HashSet<Character> characters = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            characters.add(c);
        }
        isSame = characters.size() == 1 ? true : false;

        // M4: add all chars( from string) to set, then the set size should be 1
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
    private static int reverseIterative(int originalInt) {

        // so if argument is a string, you need to think more carefully it's it's overflown for int,
        // so use long would be better or ask interviewer for that aquesiton.  use Long or Int
        // try do while instead of while , same
        int reversedNum = 0;
        while (originalInt != 0) {
            reversedNum = reversedNum * 10;   // shittttttttt, this is tricky part
            reversedNum = reversedNum + originalInt % 10;   // with extract off the right most number
            originalInt = originalInt / 10;   // remove the right most number off original one
        }
        System.out.println("reversed Int number : " + reversedNum);
        return reversedNum;
    }

    static int reverseRecursive(int n, int ans){
        if ( n == 0) return ans;
        int remainder = n % 10;
        int quotient = n /10 ;
        ans = ans * 10 + remainder;
        return reverseRecursive(quotient,ans); // when reaching the end, return 4 times in the stack from bottom to top and done.
    }

    private static void reverseIntArray(int[] arr) {
        System.out.println("------ reverse int [] ------- ");
        // swap
        for ( int i=0 ; i< arr.length/2 ; i++){
            int t = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = t;
        }

        // stream and locate from end to the beginning.
        IntStream.range(0, arr.length)
                .map( i -> arr[arr.length - i -1])
                .forEachOrdered(System.out::println);

        // only print
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


    public static String reverseRecursively(String s) {
        if ( s.length() == 0) return "";
        return reverseRecursively(s.substring(1)) + s.charAt(0);
    }


    public static int factorialRecursive(int n) {
        if ( n == 0) return 1;
        return n * factorialRecursive( n-1);
    }

    static int factorialIterative(int num){
        int product = 1;
        while ( num > 1){
            product  = product * num;
            num--;
        }
        return product;
    }


    public static int fibRecursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }


    private static int fibIterative(int nTh) {
        int prepre = 0 ;
        int pre = 1 ;
        int current = 1;

        for ( int i  = 0 ; i < nTh-1; i++){
            current = prepre + pre;
            prepre = pre;
            pre = current;
        }
        return current;
    }

}
