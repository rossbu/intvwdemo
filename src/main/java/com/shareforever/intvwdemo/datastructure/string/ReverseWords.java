package com.shareforever.intvwdemo.datastructure.string;

public class ReverseWords {

    public static void main(String[] args) {
        // so you can use this version.
        System.out.println(System.getProperty("java.version"));

        // test case 1
        char[] arr = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        char[] chars = reverseWords(arr);
        for (char c : chars) {
            System.out.println(c);
        }

        // test case 2
        char[] arr1 = {' ', ' '};
        chars = reverseWords(arr1);
        for (char c : chars) {
            System.out.println("'" + c + "'");
        }
    }


    static char[] reverseWords(char[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        reverse(arr, 0, arr.length - 1);
        int start = 0, end = 0;
        while (end < arr.length) {
            while (end < arr.length && arr[end] != ' ') { // this while will get 'end' position and quit the loop
                end++;
            }
            reverse(arr, start, end - 1);
            start = end + 1;
            end = start;
        }
        return arr;
    }

    public static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }
}
