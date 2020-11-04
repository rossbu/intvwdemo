package com.shareforever.intvwdemo.datastructure.string;


/*
 * https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
 *
    Binary: 000 -- { }
    Binary: 001 -- { X }
    Binary: 010 -- { Y }
    Binary: 011 -- { X Y }
    Binary: 100 -- { Z }
    Binary: 101 -- { X Z }
    Binary: 110 -- { Y Z }
    Binary: 111 -- { X Y Z }

 */
public class SubSet {
    public static void main(String[] args) {
//        char set[] = {'a', 'b', 'c'};
        char set[] = {'X', 'Y', 'Z'};
        printSubsets(set);
//        smartSubSet(set);
    }

    private static void smartSubSet(char[] set) {
        // given x, y , z print subset of arrays.

        // hint1: total subset:  2^n where n is the length of set, for example a,b,c, then total subsets are 2^3 = 8
        // hint2:  2^n is   1<<n  001, 010, 100  so 1+2+4 + {} == 8

        for (int i = 0; i < 1 << set.length; i++) { // 0 -> 7
            for (int j = 0; j < set.length; j++) { // j is a pointer move n times to the left 001, 010, 100
                if (((1 << j) & i) > 0) {
                    System.out.print(set[j]);
                }
            }
            System.out.println();
        }
    }


    static void printSubsets(char set[]) {
        int n = set.length;

        // Run a loop for printing all 2^n subsets one by one
        // 2^n is 1 << n  for example:  2^3 = 8  <=>  1<<3 = 8
        int numOfSubSet = 1 << n;
        System.out.println("len of outter loop : " + numOfSubSet);
        for (int i = 0; i < numOfSubSet; i++) {
            System.out.print("Binary: " + String.format("%3s", Integer.toBinaryString(i)).replaceAll(" ", "0") + " -- ");
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++) {
                // (1<<j) is a number with jth bit 1 so
                // when i 'and' them with the subset number we get which numbers are present in the subset and which are not
                // 1 << j :   001, 010, 100
                if ((i & (1 << j)) > 0) {  // only one will meet this condition
                    System.out.print(set[j] + " ");
                }
            }

            System.out.println("}");
        }
    }
}

