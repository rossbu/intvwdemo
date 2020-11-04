package com.shareforever.intvwdemo.datastructure;

import java.util.*;
import java.util.stream.Collectors;

public class SetTest {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<Integer>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        setCharacter2String();
        setString2String();
        accessIndexInSet(numbers);
    }

    private static void accessIndexInSet(Set<Integer> numbers) {

        // M1: access idx with iterator with 2 indexes
        int desiredIndex = 2;
        int currentIndex = 0;

        //iterate the HashSet
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {

            if (currentIndex == desiredIndex)
                System.out.println("Element at index " + desiredIndex + " is: " + iterator.next());
            iterator.next();
            currentIndex++;
        }

        // M2: convert it to list
        List<Integer> list = new ArrayList<Integer>(numbers);
        list.get(2);

        // M3: convert it to Array []
        Integer[] integers = numbers.toArray(new Integer[numbers.size()]);
        int i = integers[2];
    }

    private static void setCharacter2String() {
        String string = "abcdxxxnm";
        char[] arr = string.toCharArray();

        // M1 : Char[] to Set<Character> and String
        Set<Character> set1 = new LinkedHashSet<Character>();
        string.chars().forEach(e -> set1.add((char) e));

        // M2: Char[] to Set<Character> and String
        LinkedHashSet<Character> charSet = new LinkedHashSet<Character>();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (charSet.add(c)) {
                sb.append(c);
            }
        }
        System.out.println("final string: " + sb.toString());

        // M3
        String ans = charSet.stream()
                .map(e -> Character.toString(e))
                .collect(Collectors.joining());
        System.out.println(ans);

    }

    private static void setString2String() {
        LinkedHashSet<String> setNames = new LinkedHashSet<String>();
        setNames.add("John");
        setNames.add("Maria");
        setNames.add("Ryan");
        setNames.add("Emily");
        setNames.add("Sheila");
        String byJoin = String.join("", setNames);
        System.out.println(byJoin);

        LinkedHashSet<String> newSet = new LinkedHashSet<String>();
        String byCollectorsJoining = newSet.stream().collect(Collectors.joining());
        System.out.println(byCollectorsJoining);
    }
}
