package com.shareforever.intvwdemo.sorting;


import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=0SkOjNaO1XY
 * <p>
 * <p>
 * why is called 'quickSort' ??  it's partition sort.
 * this is a divide and conquer , recursive sorting algo
 * needs a smaller array in array,  pivot,  greater values in array
 * smaller number []    +    pivot    +    greater numbers []
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {
                220, 77, 377, 267, 495, 128, 297, 187, 178, 433, 138, 267, 282, 105, 38,
                363, 486, 27, 401, 256, 56, 243, 129, 227, 221, 268, 64, 320, 265, 464,
                183, 337, 214, 444, 151, 50, 348, 102, 178, 375, 471, 114, 285, 274, 370,
                61, 470, 274, 174, 261, 381, 263, 365, 192, 419
        };

        sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int pi = partition(arr, l, r);
        sort(arr, l, pi - 1); // l to p-1
        sort(arr, pi + 1, r); // p+1 to r
    }

    /**
     * partition  [lesser values] - pivot - [ greater values]  and return pivot position
     */
    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;                //  i points to last element of left array
        for (int j = l; j < r; j++) { //  j loop from L to the element before R
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // move the pivot to in between smaller room  and  greater room ->  sr -> pivot -> gr
        swap(arr, i + 1, r);
        return i + 1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
