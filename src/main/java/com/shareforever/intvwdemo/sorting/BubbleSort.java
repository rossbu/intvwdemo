package com.shareforever.intvwdemo.sorting;

import java.util.Arrays;

/**
 * best time Complexity : best case time complexity will be O(n),
 */

abstract class Animal{
    abstract void sayHello();
}
public class BubbleSort {
    public static void main(String[] args) {
//
//        int[] arr = {
//                220, 77, 377, 267, 495,
//                128, 297, 187, 178, 433,
//                138, 267, 282, 105, 38
//        };
//        solution(arr);
//
//        // print
//        Arrays.stream(arr).forEach(System.out::println);
//        System.out.println(Arrays.stream(arr).sum());

    }


    /**
     * Comlexity: o(n2)
     * <p>
     * 5 5 3 2 1 9 0
     * x x x x x x
     * x x x x x
     * x x x x
     * x x x
     * x x
     * x
     *
     * @param arr
     */
    private static void solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        boolean done = false;
        while (len > 0) {
            done = true;
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    done = false;
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
            len--;
            if (done) break;
        }
    }

    /**
     * 5 4 3 2 1
     * 4 3 2 1 5
     * 3 2 1 4 5
     * 2 1 3 4 5
     * 1 2 3 4 5
     *
     * @param arr
     */
    private static void solution1(int[] arr) {
        if (arr == null) return;
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    done = false;
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
