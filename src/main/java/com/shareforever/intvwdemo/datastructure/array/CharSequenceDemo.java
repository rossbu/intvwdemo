package com.shareforever.intvwdemo.datastructure.array;


import java.nio.CharBuffer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*

    String is a sequence of characters in Java.
    String is immutable class
    String class implements CharSequence, Serilizable and Comparable ( 3 interfaces)
    Every String object is a CharSequence.but not every CharSequence is a String.

    CharSequence is an interface that represents a sequence of characters.
    both mutable and immutable classes implement this interface.

    String, StringBuffer, StringBuilder ( java5+) all implements CharSequence.
 */
public class CharSequenceDemo {

    public static void main(String[] args) {
        String str = "acopyeofme";
        CharSequence immutable = "acopyeofme";  // mutable
        CharSequence mutable = new StringBuffer("changeme");

        System.out.println(str.equals(immutable));
        System.out.println(str == immutable);


        // char stream from char array doable???
//        This way you can use an IntStream interpreting the int values as characters
        char[] list = {'a', 'c', 'e'};
        IntStream intStream = java.nio.CharBuffer.wrap(list).chars();
        Stream<Character> characterStream = intStream.mapToObj((c -> (char) c));
        Stream<Integer> integerStream = intStream.mapToObj((c -> (int) c));


        // CharBuffer
        CharBuffer.wrap(list).chars();

        // Character  api
        Stream<String> stream = Stream.of("Geeks", "fOr", "GEEKSQUIZ", "GeeksforGeeks");
        boolean answer = stream.anyMatch(s -> Character.isUpperCase(s.charAt(1)));
        System.out.println(answer);
    }
}
