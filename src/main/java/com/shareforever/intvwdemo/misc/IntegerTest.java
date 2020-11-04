package com.shareforever.intvwdemo.misc;

public class IntegerTest {

    public static void main(String[] args) {
        String s = "sth";
        try {
            Integer nt = Integer.valueOf(s);   // valueOf internally use parseInt actually, then box it.
            int it = Integer.parseInt(s);
            System.out.print(nt);
        } catch (Exception e) {
            System.out.print("Bad String");
        }
    }
}
