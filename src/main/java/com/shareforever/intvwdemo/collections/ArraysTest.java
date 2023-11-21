package com.shareforever.intvwdemo.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysTest {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 22, 31, 12, 2123, 2323, 4, 567, 7, 8, 8, 7, 6};
    int[] ints = new int[] {};
    ints = new int[2];
    System.out.println(ints.length);
    String[][] twoDArray =
        new String[][] {
          {"tbu", "dad"},
          {"kun", "mom"},
          {"miya", "kid"},
          {"miya", "kid-updated"}
        };
    sort(arr);
    fillPrimitiveArray();
    binarySearch(arr); // the array must be sorted before binarySearch
    asList(arr);
    convert2DArray(twoDArray);
  }

  static void fillPrimitiveArray() {

    // fill char[]
    char[] letters = new char[256];
    Arrays.fill(letters, ' '); //  ' ' codepoint is 32
    java.nio.CharBuffer.wrap(letters).chars().forEachOrdered(System.out::print);
    System.out.println("\n");

    // fill int[]
    int[] nums = new int[letters.length];
    Arrays.fill(nums, 1);
    IntStream.of(nums).forEachOrdered(System.out::print);
    System.out.println("\n");

    // fill boolean[]
    boolean[] numValidity = new boolean[256];
    Arrays.fill(numValidity, false);
    Arrays.fill(numValidity, 0, 5, true); // Update the first 5 ( inclusive , exclusive)
    System.out.print(Arrays.toString(numValidity));
  }

  static void convert2DArray(String[][] doubleArray) {
    // when there are duplicate key, take the new value of the key based on order of the array
    Map<String, String> map1 =
        Stream.of(doubleArray)
            .collect(Collectors.toMap(p -> p[0], p -> p[1], (oldV, newV) -> newV));

    Map<String, String> map2 =
        Stream.of(doubleArray)
            .collect(Collectors.toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a));

    Map<String, String> map3 =
        Stream.of(doubleArray)
            .collect(Collectors.toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a, TreeMap::new));

    System.out.println("Map1:" + map1);
    System.out.println("Map2:" + map2);
    System.out.println("Map3:" + map3);
  }

  private static void asList(int[] arr) {
    Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    Arrays.asList(integerArray).forEach(System.out::println);
    HashSet<Integer> set = new HashSet<Integer>();
    Integer[] integers = set.stream().toArray(Integer[]::new);
  }

  private static void binarySearch(int[] arr) {
    int result = Arrays.binarySearch(arr, 0, arr.length - 1, 12);
    System.out.println("search result is :" + result);
  }

  /*
     Collections.sort(List, comparator)
     Arrays.sort(T[] , comparator)
  */
  private static void sort(int[] arr) {
    List<Integer> listOfNums = IntStream.of(arr).boxed().collect(Collectors.toList());
    Integer[] integers = IntStream.of(arr).boxed().toArray(Integer[]::new);
    // Collections.sort
    Collections.sort(listOfNums, (e1, e2) -> e2 - e1);
    Collections.sort(listOfNums, Collections.reverseOrder());

    //  array sort
    Arrays.sort(arr);
    Arrays.sort(arr, 0, arr.length);
    Arrays.sort(integers, (e1, e2) -> e1 - e2);
    Arrays.sort(integers, Comparator.reverseOrder());

    // output
    Arrays.stream(arr).forEach(System.out::println);
  }
}
