package com.shareforever.intvwdemo.misc;


/**
 * https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
 */
public class JavaOnlyPassByValue {


    String str = "hello string";
    char[] chars = {'c', 'h', 'a', 'r'};
    StringBuilder stringBuilder = new StringBuilder("hello stringBuilder");

    public void exchange(String str, char[] chars, StringBuilder stringBuilder) {
        str = "world";
        chars[0] = '5';
        stringBuilder = new StringBuilder("I'm a new StringBuilder");
    }

    public static void main(String[] args) {
        JavaOnlyPassByValue ro = new JavaOnlyPassByValue();

        ro.exchange(ro.str, ro.chars, ro.stringBuilder);
        System.out.println(ro.str);
        System.out.println(ro.chars);
        System.out.println(ro.stringBuilder);


        // int, Integer, String are immutable type.  you can't pass by reference of value but pass by value only ,but apache commons has mutableInt and etc.
        int i = 25;
        Integer boxedI = new Integer(25);
        String s = "Java String is fun!";
        StringBuffer sb = new StringBuffer("Hello world, String Buffer");

        // print variable i and objects s and sb
        System.out.println("^^^^^^^^^^^^ - Begin - ^^^^^^^^^^^^^^^^");
        System.out.println(i);
        System.out.println(s);
        System.out.println(sb);
        System.out.println(boxedI);


        System.out.println("^^^^^^^^^^^^^^^ - Middle - ^^^^^^^^^^^^");
        changeReferenceInt(i);
        changeReferenceInteger(boxedI);
        changeReferenceString(s);
        changeReferenceStringBuffer(sb);

        System.out.println("vvvvvvvvvvvvv - After - vvvvvvvvvvvvvv");
        System.out.println(i);
        System.out.println(boxedI);
        System.out.println(s);
        System.out.println(sb);

    }

    public static void changeReferenceInt(int iTest) {
        iTest = 9;                          // change it
        System.out.println(iTest); // print it (4)
        return;
    }

    public static void changeReferenceInteger(Integer iTest) {
        iTest = new Integer(100);                          // change it
        System.out.println(iTest);
        return;
    }

    public static void modifyReferenceInteger(Integer iTest) {
        iTest = iTest + 1; // same thing
        System.out.println(iTest);
        return;
    }


    public static void changeReferenceString(String sTest) {
        sTest = "Hello,String I am in the method";
        System.out.println(sTest);
        return;
    }

    public static void modifyReferenceString(String sTest) {
        sTest = sTest.substring(8, 11);
        System.out.println(sTest);
        return;
    }

    public static void changeReferenceStringBuffer(StringBuffer sbTest) {  // StringBuffer is just like other customized Class , that you can change the 'content' of it .
        sbTest = new StringBuffer("Hi, StringBuffer, I am in method");
        System.out.println(sbTest);
        return;
    }

    public static void modifyReferenceStringBuffer(StringBuffer sbTest) {  // StringBuffer is just like other customized Class , that you can change the 'content' of it .
        sbTest = sbTest.insert(7, " [StringBuffer insertion in Method] "); // change it
        System.out.println(sbTest);
        return;
    }
}
