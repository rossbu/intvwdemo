package com.shareforever.intvwdemo.sorting;


/**
 * http://www.cs.cmu.edu/~cburch/pgss97/slides/0716-recurse.html
 * https://medium.com/@jdelay.jr/recursion-in-javascript-a77aec90bac
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 */
public class Recursion {

    public static void main(String[] args) {

        // fibonacci
        System.out.println(fibonacci(8));     //  iterative
        System.out.println(fibonacciDP(10));  // dynamic programming
        fibIterative(8);

        // factorial
        System.out.println(factorial(5));   //  iterative
        System.out.println(factorialDP(5)); // dynamic programming
    }

    /*
        from fibonacci sequence 0,1,1,2,3,5,8,13,21.... we can see that for 5th element the fibonacci sequence returns 5

        fibonacci(5) = fibonacci(4) + fibonacci(3)

        fibonacci(3) = fibonacci(2) + fibonacci(1)

        fibonacci(4) = fibonacci(3) + fibonacci(2)

        fibonacci(2) = fibonacci(1) + fibonacci(0)

        fibonacci(2) = 1+0 = 1
        fibonacci(3) = 1+1 = 2
        fibonacci(4) = 2+1 = 3
        fibonacci(5) = 3+2 = 5
        TC is N^2
     */
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }


    /**
     * because iteration only can output up to 50 numbers due to exponetially growth. so let's try iterative now.
     * <p>
     * [0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
     * 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418,
     * 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169,
     * 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, 2971215073, 4807526976, 7778742049, 12586269025]
     */
    static int fibIterative(int input) {
        int p = 0, n = 1, r = 0;
        System.out.println(p); // first one
        System.out.println(n); // second one
        while (input-- > 0) {
            r = p + n;
            p = n;
            n = r;
            System.out.println(r);
        }

        return r;
    }

    /*
        DP : use temp array to store calculated result
        TC: linear O(n)
        SC: O(n)
     */
    public static int fibonacciDP(int n) {
        int[] fibarray = new int[n + 2]; // defaults to 0 ( byte short , int long)
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                fibarray[i] = 0;
                continue;
            }
            if (i == 1) {
                fibarray[i] = 1;
                continue;
            }
            fibarray[i] = fibarray[i - 1] + fibarray[i - 2];
        }
        return fibarray[n];
    }


    /*
     https://www.geeksforgeeks.org/program-for-factorial-of-a-number/  : simple small number
     Factorial of a non-negative integer, is the multiplication of all integers smaller than or equal to n

     6*5*4*3*2*1
     formula :   n! = n * n-1 * n-2 .... * 1
     2 ways:
        recursion : can be costly for large numbers
     */

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    /*
        DP : iterative without iteration
     */
    public static int factorialDP(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /*
        DP2:  Factorial of 100 has 158 digits  . so need a better solution
        todo
        https://www.geeksforgeeks.org/factorial-large-number/
     */

}
