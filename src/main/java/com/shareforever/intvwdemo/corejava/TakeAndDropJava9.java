package com.shareforever.intvwdemo.corejava;

import java.util.List;
import java.util.stream.Stream;


/**
 * https://www.youtube.com/watch?v=R8uwsO-CQsc
 */
public class TakeAndDropJava9 {
    public static void main(String[] args) {
        // take ( keep )--> until you can't take then break  ( when true)
        // drop ( remove )--> until you can't drop then break;
        Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck")
                .takeWhile(n -> n.length() % 2 != 0)
                .forEach(System.out::println);
        List.of(9, 7, 1, 2, 3, 4, 5).stream()
                .takeWhile(e -> e > 3)
                .forEach(System.out::println);
        System.out.println("----------");

        Stream<Integer> stream
                = Stream.of(4, 4, 4, 5, 6, 7, 8, 9, 10);
        stream.dropWhile(number -> (number / 4 == 1))
                .forEach(System.out::println);
    }
}
