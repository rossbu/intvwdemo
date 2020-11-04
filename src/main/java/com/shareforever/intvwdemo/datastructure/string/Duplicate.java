package com.shareforever.intvwdemo.datastructure.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Duplicate {

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4, 4, 6, 6};
        String input = "I am a cat cat and a cat";
        countDuplicate(input);
        removeDuplicate(input);
        Map<String, Integer> map = collectDuplicate(input);
        printMap(map);

    }

    private static void countDuplicate(String input) {
        Arrays.stream(input.split(" "))
                .collect(Collectors.toMap(Function.identity(), e -> 1, Integer::sum, LinkedHashMap::new))
                .forEach((e1, e2) -> {
                    System.out.println(e1 + ":" + e2);
                });
    }

    private static void removeDuplicate(String input) {
        Arrays.asList(input.split(" ")).stream().collect(Collectors.toSet()).forEach(System.out::println);

        Arrays.stream(input.split(" ")).distinct().collect(Collectors.toList()).forEach(System.out::println);

        Set hashSet = new LinkedHashSet(Arrays.asList(input.split(" ")));
        hashSet.forEach(System.out::println);
    }

    private static void printMap(Map<String, Integer> map) {
        // print map.foreach directly without stream
        map.forEach(
                (e1, e2) ->
                {
                    if (e2 > 1) {
                        System.out.println(e1 + ": " + e2);
                    }
                }
        );


        // print : KeySet  ( key then get(key)
        Loop0:
        {
            for (String key : map.keySet()) {
                Integer value = map.get(key);
                System.out.println(key + "=" + value);
            }
        }
        Loop1:
        {
            for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); ) {
                String key = it.next();
                Integer value = map.get(key);
                System.out.println(key + "=" + value);
            }
        }
        Loop2:
        {
            Iterator<String> itr = map.keySet().iterator();
            while (itr.hasNext()) {
                String key = itr.next();
                Integer value = map.get(key);
                System.out.println(key + "=" + value);
            }
        }
    }

    private static Map<String, Integer> collectDuplicate(String input) {
        // java 8 - collect duplicates
        Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(System.out::println);

        // java 6 - collect duplicates
        String[] array = input.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        return map;
    }
}
