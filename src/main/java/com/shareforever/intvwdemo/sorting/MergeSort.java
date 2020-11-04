package com.shareforever.intvwdemo.sorting;

import java.util.Arrays;
import java.util.*;
import java.util.stream.*;

/**
 * https://stackabuse.com/sorting-algorithms-in-java/
 * https://codereview.stackexchange.com/questions/61728/merge-sort-implementation-in-java-that-seems-slow
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {
                220, 77, 377, 267, 495, 495,
                128, 297, 187, 178, 433,
                138, 267, 282, 105, 105, 38,
                220, 77, 377, 267, 4334, 495,
                128, 297, 187, 178, 433,
                138, 234, 282, 105, 105, 38
        };

        Random r = new Random();
        int[] testarr = new int[100];
        for (int i = 0, len = testarr.length; i < len; i++) {
            testarr[i] = r.nextInt(2500);
        }

        // sort1 : straightforward
        int[] sortedarr = sort1(testarr);
        IntStream.of(sortedarr).forEach(System.out::println);
        System.out.println();


        // sort2 use buffer , better than sort1
        sort2(arr);

        // print out
        IntStream.of(arr).forEach(System.out::println);

    }

    /*
        use a buffer array instead of allocating/splitting a new temp array everyime.
     */
    public static void sort2(int[] arr) {
        sort2(arr, new int[arr.length], 0, arr.length);
    }

    public static void sort2(int[] arr, int[] buffer, int start, int end) {
        int half = (start + end) / 2;
        if (start + 1 < end) {
            sort2(arr, buffer, start, half);
            sort2(arr, buffer, half, end);
            merge2(arr, buffer, start, half, end);
        }
    }

    public static void merge2(int[] array, int[] buffer, int start, int mid, int end) {
        System.arraycopy(array, start, buffer, start, end - start);
        int index1 = start, index2 = mid;
        int resultIndex = start;

        while (index1 < mid && index2 < end) {
            if (buffer[index1] < buffer[index2]) {
                array[resultIndex++] = buffer[index1++];
            } else {
                array[resultIndex++] = buffer[index2++];
            }
        }

        // deal with the rest/straggler
        if (index1 < mid)
            System.arraycopy(buffer, index1, array, resultIndex, mid - index1);
        if (index2 < end)
            System.arraycopy(buffer, index2, array, resultIndex, end - index2);

    }


    public static int[] sort1(int[] arr) {
        if (arr.length <= 1) return arr;

        int len = arr.length;
        int half = len / 2;

        int[] arr1 = Arrays.copyOfRange(arr, 0, half);
        int[] arr2 = Arrays.copyOfRange(arr, half, len);

        int[] sorted1 = sort1(arr1);
        int[] sorted2 = sort1(arr2);

        int[] result = merge1(sorted1, sorted2);
        return result;

    }
    /*
         arr1 : 1,3,5
         arr2 : 2,4,6,8,10
         straggler elements like number 8 and 10 from
               this just use a different loop While instead of for loop, no big improvement.
    */

    private static int[] merge1(int[] left, int[] right) {
        int len1 = left.length, len2 = right.length;
        int totalLength = len1 + len2;
        int[] result = new int[totalLength];
        /* ORIGINAL MERGING STRATEGY */
          /*
          for(int i = 0, i1 = 0, i2 = 0; i < totalLength; ) {
            if(i1 >= len1) {
                while(i2 < len2) {
                    result[i++] = right[i2++];
                }
                break;
            } else if(i2 >= len2) {
                while(i1 < len1) {
                    result[i++] = left[i1++];
                }
                break;
            }
            if(left[i1] > right[i2]) {
                result[i++] = right[i2++];
            } else {
                result[i++] = left[i1++];
            }
        }
        */
        /* MODIFIED MERGING STRATEGY */
        int counterForLeft = 0, counterForRight = 0, resultIndex = 0;
        while (counterForLeft < len1 || counterForRight < len2) {
            if (counterForLeft < len1 && counterForRight < len2) {
                if (left[counterForLeft] <= right[counterForRight]) {
                    result[resultIndex++] = left[counterForLeft++];
                } else {
                    result[resultIndex++] = right[counterForRight++];
                }

            } else if (counterForLeft < len1) {
                result[resultIndex++] = left[counterForLeft++];

            } else if (counterForRight < len2) {
                result[resultIndex++] = right[counterForRight++];
            }
        }
        return result;
    }

    public static int[] merge(int[] arr1, int[] arr2) {

        int[] newarr = new int[arr1.length + arr2.length];

        for (int i1 = 0, i2 = 0, i = 0; i < newarr.length; ) {

            if (i1 >= arr1.length) {
                while (i2 <= arr2.length - 1) {
                    newarr[i++] = arr2[i2++];
                }
            }

            if (i2 >= arr2.length) {
                while (i1 <= arr1.length - 1) {
                    newarr[i++] = arr1[i1++];
                }
            }


            if (arr1[i1] < arr2[i2]) {
                newarr[i++] = arr1[i1++];
            } else {
                newarr[i++] = arr2[i2++];
            }


        }

        return newarr;


    }

}
