package com.shareforever.intvwdemo.datastructure.string;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HighestNumber {
    public static void main(String[] args) {
        int[] ints = {1, 20, 2, 34, 5, 6, 7, 88, 102, 99, 99};
        find2ndHighestNumber(ints);
        find2ndhighestNum(ints);
    }

    /**
     * can't solve duplicity
     *
     * @param ints
     */
    private static void find2ndhighestNum(int[] ints) {
        int n = 0;
        boolean done;
        while (n < ints.length) {
            done = true;
            for (int i = 0, j = 1; j < ints.length; i++, j++) {
                if (ints[i] >= ints[j]) {
                    done = false;
                    swap(ints, i, j);
                }
            }
            n++;
            if (done) break;
        }

        System.out.println(ints[ints.length - 2]);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // java 8   Stream(int[])  to Stream(Integer)   use
    private static void find2ndHighestNumber(int[] ints) {
        Stream.of(ints)
                .distinct()
                .sorted()
                .collect(Collectors.toList());  // Wrong don't ever use this Stream.of(int[])

        Stream.of("foo", "test", "a")
                .sorted(Comparator.comparingInt(String::length).reversed());

        IntStream.of(ints)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .collect(Collectors.toList());

        List<Integer> list = IntStream.of(ints)
                .mapToObj(e -> Integer.valueOf(e))
                .sorted(Comparator.reverseOrder())
                .distinct()
                .collect(Collectors.toList());


        IntStream.of(ints)
                .mapToDouble(Double::valueOf)
                .sorted().distinct();
        System.out.println(list.get(1));
    }
}
