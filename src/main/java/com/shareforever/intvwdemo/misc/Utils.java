package com.shareforever.intvwdemo.misc;

public class Utils {


    public static void main(String[] args) {

    }

    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) // here ++i and i++ are the same
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
