package com.shareforever.intvwdemo.sorting;

import com.shareforever.intvwdemo.misc.Utils;

import java.util.Arrays;


/*
     3 5 7 8 4 2 1 9 6  ( e.g, let's move 4 to the left )
     3 5 7 x 8 2 1 9 6
     3 5 x 7 8 2 1 9 6
     3 x 5 7 8 2 1 9 6
     3 x 5 7 8 2 1 9 6   ( insert the card : arr[j + 1] = currentCard; )
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {
                220, 77, 377, 267, 495,
                128, 297, 187, 178, 433,
                138, 267, 282, 105, 38,
                363, 486, 27, 401, 256,
                56, 243, 129, 227, 221,
                268, 64, 320, 265, 464,
                183, 337, 214, 444, 151
        };

        solution3(arr);
        Arrays.stream(arr).forEach(System.out::println);

    }

    private static void solution3(int[] arr) {
        if (arr == null) return;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int currentCard = arr[i];
            int j = i - 1;

            // move cards to the right
            while (j >= 0 && arr[j] > currentCard) {
                arr[j + 1] = arr[j];
                j--;
            }

            // insert card to the stopping point from above loop
            arr[j + 1] = currentCard;
        }
    }

    private static void solution2(int[] arr) {
        if (arr == null) return;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int cardInhard = arr[i];
            int j = i - 1;
            while (j >= 0 && cardInhard < arr[j]) {
                arr[j + 1] = arr[j]; // move the card forward to right
                j--;
            }
            arr[j + 1] = cardInhard;
        }
    }

    /**
     * play cards
     *
     * @param arr
     */
    private static void solution(int[] arr) {
        if (arr == null)
            return;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    Utils.swap(arr, j, j - 1);// swap is not a real insertion
                }
                j--;
            }
        }
    }


}
