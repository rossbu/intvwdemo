package com.shareforever.intvwdemo.datastructure.tree;


import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=P3YID7liBug
 * https://www.javatpoint.com/binary-search-in-java
 * <p>
 * The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * The left and right subtree each must also be a binary search tree.
 */
public class BinarySearch {

    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {40, 2, 12, 34, 3, 44, 4, 41, 11, 10, 50, 40};
        int n = arr.length;
        int x = 10;

        // without sorting and search , you get WRONG result
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);


        // Now sort before binarySearch,  return correct index
        Arrays.sort(arr);
        int result1 = Arrays.binarySearch(arr, x);
        if (result1 == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result1);
    }

    // Returns index of x if it is present in arr[l..r], else return -1
    int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

}
