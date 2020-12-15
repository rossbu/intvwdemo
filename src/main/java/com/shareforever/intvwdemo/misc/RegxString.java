package com.shareforever.intvwdemo.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class RegxString {


    /*

        Best: https://webagility.com/posts/the-basics-of-regex-explained
        cheatsheet: https://cheatography.com/davechild/cheat-sheets/regular-expressions/


        \  :  first and foremost  the dash \ needs to be escaped , so use \\


        ^  : inside square brackets, it negates the pattern
             e.g.   [^abc] When a caret ^ appears as the first character

        ^  : outside of the square brackets the ^ meanns the start of string, a new meaning


        $  : when used  outside of the square brackets the $ meanns the end of string, a new meaning
            e.g.   ^[0-2]$ - Match only strings being “0”, “1”, or “2” without any other text.




        \d+ : matches one or more digits
        \D+ : matches one or more non-digits
        \s+ : matches one or more whitespaces or tabs
        \S+ : matches one or more non-whitespaces
        \w+ : matches all letters
        \W+ : matches all non-letters e.g   this is equals to [^\\w+]

        [] : Alternative, Everything you put inside these brackets are alternatives in place of one character.
            [DB]an - Matches “Dan” and “Ban” (first letter can be "D" or "B").

        . : dot match any characters

        * : {0,} , 0 or more times  e.g  X* finds no or several letter X

        ? : {0,1} , 0 or 1 time  e.g  X? find one X or NO
            e.g.    \\w+\\.?    .? means 0 or 1 dot    so  end  end. are true

        ^ appears as the first character inside square brackets, it negates the pattern
            e.g : [^\w+] : match all non-word
     */
    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        String str1 = "abc   123      c    456  ";
        System.out.println(str1.replaceAll("\\D+", ""));
        Thread.sleep(1000);
        long end = System.nanoTime();
        System.out.println("time elapsed: " + (end - start) / 1_000_000_000 + "s"); // 1 second =   1_000_000_000 nanosecond

        System.out.println(str1.replaceAll("\\s+", ""));
        Arrays.stream(str1.split("\\s+")).forEach(System.out::println);

        String names = "alex,brian,charles,david";
        Pattern p = Pattern.compile(",");
        Arrays.asList(p.split(names)).forEach(System.out::println);


        names.toCharArray();
        System.out.println(String.valueOf(names.toCharArray()));
    }


}
