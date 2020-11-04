package com.shareforever.intvwdemo.misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MiscDemo {
    static  { // it can'e be executed without Main from JDK7+
        System.out.println("Static Initalizer");
//        System.exit(0);
    }
    /** Actual main method with String[] args**/
    public static final void main(String[] args) {
        main(new Double[] { 1.0, 2.0, 3.0 }); // overloaded Main method with diff type of arguments
        trickyTenaryReturn();
        trickyWhileLoop();
        weirdForPrint();
        compareInt();
        power(3, 5);
        operatorMinus();
        stackTry();

    }

    /*
     you can Overloaded main method with Double[] args
     you can use final for main method
     */
    public static final void main(Double[] args) {
        System.out.println("Double[] args main method called");
        System.out.println(Arrays.toString(args));
    }

    /*
        Tenary operator is an EXPRESSION
        result = someCondition ? value1 : value2 ;
     */
    private static boolean trickyTenaryReturn() {
        return  1 ==1 ? true : false;
//        1 == 1 ? return true : return false;  // syntax error. you can't use return in tenary operation.

    }

    private static void trickyWhileLoop() {
        int len = 0;
        while (len-- > 0) {
            ;
            ;
        } // -- is execusted not matter true or false  so it's -1
        System.out.println(len); // end = 1 now.
    }

    private static void stackTry() {
        Deque<Character> stack = new ArrayDeque<Character>();
        stack.push('{');
        stack.push('(');
        stack.push(')');
        stack.push('}');
        String expr = "{()}";
        for (int i = 0; i < stack.size(); i++) {
            char x = expr.charAt(i);
            switch (x) {
                case '(':
                    stack.pop();
                    if (x == '{' || x == '[') {
                        System.out.println("test");
                        break;
                    }


                case '{':
                    stack.pop();
                    if (x == '(' || x == '[') {
                        System.out.println("test2");
                    }
                    break;
            }

        }

    }

    /*
        Sample Input
            4   ( test cases as T)
            3 5
            2 4
            -1 -2
            -1 3

        Sample Output
            243
            16
            n and p should be non-negative
            n and p should be non-negative
     */
    static int power(Integer n, Integer p) throws ArithmeticException {
        if (n < 0 || p < 0) throw new ArithmeticException("n and p should be non-negative");
        if (p == 0) return 1;
        if (p == 1) return n;
        int ans = 1;
        while (p >= 1) {
            ans = ans * n;
            p--;
        }
        return ans;
    }


    /*
     for loop sequence:
        1 First, initialization is performed (i=0)
        2 the check is performed (i < n)
        3 the code in the loop is executed.
        4 the value is incremented
        5 Repeat steps 2 - 4
     */
    private static void operatorMinus() {
        int idx = 5;
        System.out.println("i++ and ++i are Different effect in While loop");
        while (idx-- > 0) {  //  when idx == 1 , will be in the loop and then idx = idx -1
            System.out.print(idx + " ");
        }
        System.out.println("\n");

        idx = 5;
        while (--idx > 0) {  // when idx == 1,  will NOT be in the loop since idx = idx - 1 befor evaluation.
            System.out.print(idx + " ");
        }

        System.out.println("\ni++ and ++i are same effect in for loop");
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("\ni++ and ++i are same effect in for loop");
        for (int i = 0; i < 10; ++i) {
            int j = 10;
            System.out.println("i = " + i);
        }
    }


    private static void compareInt() {
        String a = "223";
        String b = "1234";
        String c = "2234";
        String d = "223";
        System.out.println(a.compareTo(b));  // 1  , so 223  is greater than 1234
        System.out.println(c.compareTo(b));  // 1  , so 2234 is greater than 1234
        System.out.println(a.compareTo(d));  // 0
    }

    public static void weirdForPrint() {
        for (int i = 0; i < 10; System.out.println("hello")) {
            if (i == 5) break;
            i++;
        }
    }
}
