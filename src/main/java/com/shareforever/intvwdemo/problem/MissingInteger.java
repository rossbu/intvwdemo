package com.shareforever.intvwdemo.problem;

import java.util.HashSet;

/**
 * question:
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 * <p>
 * Answer:
 * https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 * <p>
 * given an array A of N integers,
 * returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example,
 * Given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [0, −1, −3], the function should return 1.
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MissingInteger {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, -1, 0, 99};
        int num = solution1(arr);
        System.out.println("num: " + num);
    }

    /**
     * Sorting from small to big, bubble or Insertion sort,
     * Scan new array for positive integer until the biggest one without next continuous integer. and return the missing.
     *
     * @param arr
     * @return
     */
    private static int solution1(int[] arr) {
        if (arr.length == 0) {
            return 1;
        }

        for (int i = 0; i < arr.length; i++) {
            int temp;
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        return 1;
    }


    public static int solution2(int[] A) {
        int num = 1;
        HashSet<Integer> hset = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            hset.add(A[i]);
        }
        while (hset.contains(num)) {
            num++;
        }
        return num;
    }

    /**
     * https://bogdankotzev.com/codility-missing-integer-java-solution/
     *
     * @param A
     * @return
     */
    public static int solution3(int[] A) {
        // variable representing the number of elements in A
        int A_N = A.length;
        // boolean array that represents the smallest positive values in A
        // size is A_N + 1 because I am not using index 0 for simplicity
        boolean[] B = new boolean[A_N + 1];
        // variable representing the number of elements in B
        int B_N = B.length;

        // iterate through A and update B accordingly
        for (int i = 0; i < A_N; i++) {
            // if a value is greater than 0 (since we only care about positive values)
            // AND if value is within B's range
            if (A[i] > 0 && A[i] < B_N) {
                // update B to show that A contains that number
                B[A[i]] = true;
            }
        }
        // iterate through Boolean array B
        for (int i = 1; i < B_N; i++) {
            // return the first value in B that is false
            if (B[i] == false) {
                return i;
            }
        }

        // if all of the values inside B are true(except 0), then we return the next biggest integer
        return B_N;
    }
}
