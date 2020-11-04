package com.shareforever.intvwdemo.corejava;

import java.util.HashSet;
import java.util.Set;


/**
 * http://wiki.c2.com/?DoubleBraceInitialization
 */
public class DoubleBraceInitialization {

    // 2 steps to create and initialization hashset
    private static final Set<String> VALID_CODES = new HashSet<String>();

    static {
        VALID_CODES.add("XZ13s");
        VALID_CODES.add("AB21/X");
        VALID_CODES.add("YYLEX");
        VALID_CODES.add("AR2D");
    }

    // 1 step - This only works for non-final classes because it creates an anonymous subclass

    private static final Set<String> VALID_CODES_INNER = new HashSet<String>() {{
        this.add("XZ13s");
        this.add("AB21/X");
        this.add("YYLEX");
        this.add("AR2D");
    }};

    public static void main(String[] args) {
        VALID_CODES_INNER.forEach(System.out::println);
    }

    public void doublebraceLocalInnerClass() {
        final Set<String> VALID_CODES_INNDER = new HashSet<String>() {
            {
                add("XZ13s");
                add("AB21/X");
                add("YYLEX");
                add("AR2D");
            }
        };
    }


}
