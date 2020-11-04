package com.shareforever.intvwdemo.datastructure.string;

/*
        // https://www.geeksforgeeks.org/repeat-substrings-of-the-given-string-required-number-of-times/?ref=rp

 */
public class RepeatedString {

    public static void main(String[] args) {
        repeatSubStringsOfGivenTimesInString("2a10bd3");    //    2,10,3   and  "",a,bd
        repeatSubStringsOfGivenTimesInString("3a");         //    "",a   and  3
        repeatSubStringsOfGivenTimesInString("b4");
        repeatSubStringsOfGivenTimesInString("b");
        repeatSubStringsOfGivenTimesInString("");
        repeatSubStringsOfGivenTimesInString(null);
    }

    /*
        Repeat substrings of the given String required number of times
     */
    private static void repeatSubStringsOfGivenTimesInString(String str) {
        if (null == str || str.length() == 0) return;
        String[] letters = str.split("\\d+");
        String[] numbers = str.split("\\D+");
        String output = "";
        for (int l = 0, n = 0; l < letters.length; ) {
            String letter = letters[l];
            if (n >= numbers.length) {
                output = output + letter;
                break;
            }
            String number = numbers[n];
            if (letter.equals("")) {  // "" means num is the leading value in string.
                output = output + number;
            } else if (number.equals("")) {
                n++;
                continue;
            } else {
                int times = Integer.valueOf(number);
                for (int i = 0; i < times; i++)
                    output = output + letter;
            }
            l++;
            n++;
        }
        System.out.println(output);
    }
}
