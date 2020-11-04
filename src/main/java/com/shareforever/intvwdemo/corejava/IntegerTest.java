package com.shareforever.intvwdemo.corejava;

public class IntegerTest {

    /*
        Integer.compareUnsigned
        x==y ->     =0
        x>y ->      >0
        x<y ->      <0
        similarly:
        compare(int a, int b) returns
            1 if a > b,
            0 if a == b,
            -1 a < b
     */
    public static void main(String[] args) {
        IntegerCacheTest();
        compare();
    }

    /*
     hint: IntegerCache between -128 to 127
           java.lang.Integer.IntegerCache.high  can be set highter than 127 when intilization.
           may be controlled by the {@code -XX:AutoBoxCacheMax=<size>} option.
     */
    private static void IntegerCacheTest() {
        Integer a = 100, b = 100, c = 129, d = 129;
        System.out.println("a==b -> " + (a == b));
        System.out.println("c==d -> " + (c == d));
        System.out.println();
    }

    private static void compare() {
        Integer x = 3;
        Integer y = null;

        // 1st test
        try {
            // if the first is true , second won't be evaluated ,
            // so won't throw exception. otherwise , nullpointer is thrown.
            boolean result = Integer.compareUnsigned(x, 3) == 0 || Integer.compareUnsigned(y, 0) == 0;
            System.out.println(result);
        } catch (Exception ex) {
            System.out.println(ex.getClass().toString());
        }

        // 2nd test
        try {
            System.out.println(y.compareTo(null) == 0 || true);
        } catch (Exception ex) {
            System.out.println(ex.getClass().toString());
        }

        // weird test :  which indicates -1 is greater than 2
        /*
            The range of signed int values is -2^31 to 2^31-1. The value 0 is in the middle.
            The range of unsigned int is 0 to 2^32-1 with 0 being the lowest number.
         */
        System.out.println(Integer.compareUnsigned(-1, 2));
    }
}
