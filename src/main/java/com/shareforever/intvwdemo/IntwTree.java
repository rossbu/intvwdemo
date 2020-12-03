package com.shareforever.intvwdemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

;

public class IntwTree {
    public static void main(String[] args) {
        // testcases
        String[] testcases = new String[]{"abcd", null, "", "aaaa", "abcaaa","a","abc"};


        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------  Tree Section ---------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");


        // binary search ( simple version use Arrays.sort and Arrays.binarySearch)
        int[] arr = {40, 2, 12, 34, 3, 44, 4, 41, 11, 10, 50, 40};
        int x = 10;
        Arrays.sort(arr);
        int ele1 = Arrays.binarySearch(arr, x);
        System.out.println("found ele1: " + ele1);

        // binary Search complex version
        int ele2 = binarySearch(arr, 10);
        System.out.println("found ele2: " + ele2);

        // convert a left unbalanced BST to a balanced BST
        // https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/?ref=rp
        convertUnBalancedBST2BalancedBST();

        // Valid Parentheses Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
        // The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
        System.out.println("{}[]() is closed : " + isValidParentheseUsing2Pointers("{}[]()"));
        System.out.println("{}[](1) is closed : " + isValidParentheseUsing2Pointers("{}[](1)"));
        System.out.println("{}[]9 is closed : " + isValidParentheseUsing2Pointers("{}[]9"));

        // Balanced Parentheses , harder.
        boolean balanced = isBalancedParentheses("[()]{}{[()()]()}");
//        boolean balanced =isBalancedParentheses("(}()");
        System.out.println("balanced : " + balanced);

    }


    /*
      // [()]{}{[()()]()} : Balanced  and    [(])  : Not-Balanced
      // write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
     */
    static boolean isBalancedParentheses(String s) {         // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();

        // Traversing the Expression
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            // IF current current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;

            switch (x) {
                case ')':
                    x = stack.pop();
                    if (x == '{' || x == '[') {
                        System.out.println(x);
                        return false;
                    }
                    break;

                case '}':
                    x = stack.pop();
                    if (x == '(' || x == '[')
                        return false;
                    break;

                case ']':
                    x = stack.pop();
                    if (x == '(' || x == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }

    static void convertUnBalancedBST2BalancedBST() {
    }



    static int binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int result = binarySearch(arr, left, right, n);
        return result;
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

    /*
     myself uses this way.
     */
    static boolean isValidParentheseUsing2Pointers(String testString) {
        if (testString == null || "".equals(testString)) return false;
        if (testString.length() % 2 != 0) return false;

        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put('<', '>');
        hashMap.put('{', '}');
        hashMap.put('[', ']');
        hashMap.put('(', ')');
        char[] charArray = testString.toCharArray();
        for (int i = 0, j = i + 1; j < charArray.length; i = i + 2, j = i + 1) {
            char currentc = charArray[i];
            char nextc = charArray[j];
            char closingChar = hashMap.get(currentc);
            if (closingChar != nextc)
                return false;
        }
        return true;
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



}
