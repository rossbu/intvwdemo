package com.shareforever.intvwdemo.misc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

public class MathDemo {
    static DecimalFormat df = new DecimalFormat("##0.000000");

    /*
        whole number -  Integer type
            byte	1 byte	Stores whole numbers from -128 to 127
            short	2 bytes	Stores whole numbers from -32,768 to 32,767
            int	    4 bytes	Stores whole numbers from -2,147,483,648 to 2,147,483,647
            long	8 bytes	Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807

        fractional number - Floating point
            float	4 bytes	Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
            double	8 bytes	Stores fractional numbers. Sufficient for storing 15 decimal digits
            BigDecimal:  guess...... not only number, but operations

     */
    public static void main(String[] args) {
        // bsil
        byte anum = 126;             // Integer (whole number) This can be used instead of int or other integer types to save memory when you are certain that the value will be within -128 and 127
        short bnum = 23456;         // Integer (whole number) The short data type can store whole numbers from -32768 to 32767
        int cnum = 2147483647;       // Integer (whole number) The int data type can store whole numbers from -2147483648 to 2147483647
        long dnum = 69747979343932L; // Integer (whole number) -9223372036854775808 to 9223372036854775807

        // fdb
        float aFloatNum = 5.99f;     // Floating point number , can store fractional numbers from 3.4e−038 to 3.4e+038. Note that you should end the value with an "f":
        double bDoubleNum = 5.4567d; // can store fractional numbers from  1.7e−308 to 1.7e+308. Note that you should end the value with a "d":
        BigDecimal aDecimal = new BigDecimal("0.03");  // MONEY and COST,  pleeeease use BidDecimal.  don't be illegal.

        char myLetter = 'D';         // Character
        boolean myBool = true;       // Boolean
        String myText = "Hello";     // String

        betterDecimal();
        divisionTest();
        decimalTest();
        calculateTotalCost(12, 20, 8);
        bigDecimalRound(12, 20, 8);
    }

    private static void betterDecimal() {
        double a = 0.02;
        double b = 0.03;
        double c = b - a;
        System.out.println(c);

        BigDecimal _a = new BigDecimal("0.02");
        BigDecimal _b = new BigDecimal("0.03");
        BigDecimal _c = _b.subtract(_a);
        System.out.println(_c);


        float f1 = 10f;
        float f2 = 3f;
        System.out.println("Float:\t 10 / 3 = " + (f1 / f2));
        double d1 = 10;
        double d2 = 3;
        System.out.println("Double:\t 10 / 3 = " + (d1 / d2));


        BigDecimal bd3 = new BigDecimal("10");
        BigDecimal bd4 = new BigDecimal("3");
        System.out.println("BigDec:\t 10 / 3 = " + (bd3.divide(bd4, 4, RoundingMode.HALF_UP)));
    }

    /*
        https://www.hackerrank.com/challenges/30-operators/problem
     */
    static void calculateTotalCost(double meal_cost, int tip_percent, int tax_percent) {
        double totalCost = 0;
        double tipCost = (meal_cost * tip_percent) / 100;
        double taxCost = (meal_cost * tax_percent) / 100;
        totalCost = Math.floor(meal_cost + tipCost + taxCost);
        System.out.println("total cost: " + (int) totalCost);
    }

    static void bigDecimalRound(double meal_cost, int tip_percent, int tax_percent) {
        BigDecimal totalCost = new BigDecimal(0);
        BigDecimal ONE_HUNDRED = new BigDecimal(100);
        BigDecimal b_tip_percent = new BigDecimal(tip_percent);
        BigDecimal b_tax_percent = new BigDecimal(tax_percent);

        BigDecimal b_meal_cost = new BigDecimal(meal_cost);
        BigDecimal tipCost = b_meal_cost.multiply(b_tip_percent).divide(ONE_HUNDRED);
        BigDecimal taxCost = b_meal_cost.multiply(b_tax_percent).divide(ONE_HUNDRED);

        totalCost = b_meal_cost.add(tipCost);
        totalCost = totalCost.add(taxCost);
        totalCost = totalCost.setScale(2, RoundingMode.HALF_DOWN);
        System.out.println("total cost: " + totalCost.intValue());

        BigDecimal bD1 = new BigDecimal("5.46597");
        bD1 = bD1.setScale(2, RoundingMode.HALF_DOWN); // 5.47

        BigDecimal bD2 = new BigDecimal("5.46500");
        bD2 = bD2.setScale(2, RoundingMode.HALF_DOWN); // 5.46
    }


    /*
        Better in order
        float -> double -> Decimal

        The double data type is more precise than float in Java.
        double has a higher range than float, sure because it got more bits to store data.
        double takes more space than float in Java. double needs 64-bit storage compare to 32-bit storage of float data type.

        1) Both double and float are used to represent real numbers in Java i.e. numbers with fractions or decimal points.

        2) Both double and float are approximate types, they are not precise.

        3) You should use logical operator e.g. > or < to compare both float and double variables, instead of = and != because they are not precise.

        float type : 'f' or 'F in the end or (float) 3.14;
    */
    static void decimalTest() {
        float pie = 3.14f;
        float pie2 = (float) 3.14;
        double a = 1.0909090f;
        double b = 5.121221d;
        System.out.println(pie == pie2);
        System.out.println(df.format(new BigDecimal(2 / 5))); // this will output 0.000000 which is WRONG.
        System.out.println(df.format(2f / 5f));
        System.out.println(df.format(2d / 5d));
        System.out.println(df.format(new BigDecimal(2d / 5d)));
        System.out.println(df.format(new BigDecimal(2).divide(new BigDecimal(5))));
    }

    /*
        %  remainder or modulus operator
        /  quotient operator
    */
    private static void divisionTest() {

        // reminder ( MODULUS or Modulo or Mod)
        System.out.println(22 % 3);  //  it produces the remainder of dividing the first value by the second value.

        // Quotient:  22 is divided by 3, so the quatient is 7 and remainder is 1
        System.out.println(22 / 3);

        int dividend = 556, divisor = 9;
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        System.out.println("The Quotient is = " + quotient);
        System.out.println("The Remainder is = " + remainder);
    }


    /**
     * Example
     * <p>
     * There are  elements, two positive, two negative and one zero. Their ratios are ,  and . Results are printed as:
     * <p>
     * 0.400000
     * 0.400000
     * 0.200000
     */
    public static void format1() {
        int[] arr = {-4, 3, -9, 0, 4, 1};
        int len = arr.length;
        double positive = 0;
        double negitive = 0;
        double zero = 0;
        for (int i : arr) {
            if (i > 0)
                positive++;
            else if (i == 0)
                zero++;
            else
                negitive++;
        }
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format(positive / len));
        System.out.println(df.format((double) negitive / len));
        System.out.println(df.format(zero / len));
    }

    private static void format2() {
        int[] array = {-4, 3, -9, 0, 4, 1};
        int[] sum = new int[3];
        double total = array.length;
        for (double d : array) {
            sum[Double.compare(d, 0) + 1]++;
        }

        DecimalFormat df = new DecimalFormat("#.000000");
        System.out.println(df.format(sum[2] / total));
        System.out.println(df.format(sum[0] / total));
        System.out.println(df.format(sum[1] / total));
    }
}
