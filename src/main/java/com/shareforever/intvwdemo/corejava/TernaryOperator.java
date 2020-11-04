package com.shareforever.intvwdemo.corejava;

import java.util.function.BinaryOperator;


public class TernaryOperator {
    public static void main(String[] args) {

        // tricky evaluation
        boolean b;
        System.out.println((b = true) ? "true" : "false");

        // ++ will be executed after
        int c = 0;
        System.out.println((0 == c++) ? "true" : "false");

        // null can' be used for instanceof
        Double d = null;
        System.out.println((d instanceof Double) ? "true" : "false"); // instance will be evaluated on 'instance' if any.not on null

        // ternary operator
        int a = 0;
        System.out.println(a != 0 ? "true" : "false");

        // binary operator ( extends biFunction<T,U,R>,
        BinaryOperator<String> b1 = (String x, String y) -> x + y; // simplified for only one type T
        // BinaryOperator<String,String,String> b2 = (String x, String y) -> x+y; // compilation error

        // != or = is used for reference pointer Comparision : Constant pool test
        String e = "1";
        System.out.println((e != "1") ? "true" : "false");

        // new String in regular heap space, as other objects.
        String x = new String("1");
        System.out.println((x == new String("1")) ? "true" : "false");
    }

}
