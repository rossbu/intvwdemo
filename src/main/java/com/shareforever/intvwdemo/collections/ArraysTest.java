package com.shareforever.intvwdemo.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysTest {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 22, 31, 12, 2123, 2323, 4, 567, 7, 8, 8, 7, 6};
        String[][] doubleArray = new String[][]{
                {"tbu", "dad"},
                {"kun", "mom"},
                {"miya", "kid"}};

        fill();
        sort(arr);
        binarySearch(arr); // the array must be sorted before binarySearch
        asList(arr);
        doubleArray(doubleArray);
    }

    static void fill() {
        char[] letters = new char[256];
        Arrays.fill(letters, ' ');
        System.out.println("fill empty char length is : " + letters.length);

        int[] nums = new int[letters.length];
        Arrays.fill(nums, 1);
        System.out.println("fill empty int length is : " + nums.length);

        boolean[] numValidity = new boolean[256];
        Arrays.fill(numValidity, false);
        Arrays.fill(numValidity, 0, 5, true);  // Update the first 5 ( inclusive , exclusive)
        System.out.print(Arrays.toString(numValidity));


    }

    static void doubleArray(String[][] doubleArray) {
        Map<String, String> map1 = Stream.of(doubleArray).collect(Collectors.toMap(p -> p[0], p -> p[1]));

        Map<String, String>
                map2 = Stream.of(doubleArray)
                .collect(Collectors
                        .toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a));

        Map<String, String>
                map3 = Stream.of(doubleArray)
                .collect(Collectors
                        .toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a, TreeMap::new));


        System.out.println("Map1:" + map1);
        System.out.println("Map2:" + map2);
        System.out.println("Map3:" + map3);

    }

    private static void asList(int[] arr) {
        Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.asList(integerArray).forEach(System.out::println);
    }

    private static void binarySearch(int[] arr) {
        int result = Arrays.binarySearch(arr, 0, arr.length - 1, 12);
        System.out.println("search result is :" + result);
    }

    private static void sort(int[] arr) {
        Arrays.sort(arr, 0, arr.length);
        // unfortunately you have to BOXED it and do reverse sort
        Integer[] arr2 = IntStream.of(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Comparator.reverseOrder());
//        Arrays.stream(arr2).forEach(System.out::println);
    }
}
