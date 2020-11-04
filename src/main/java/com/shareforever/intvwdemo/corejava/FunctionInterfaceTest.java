package com.shareforever.intvwdemo.corejava;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class FunctionInterfaceTest {
    static int index = 0;

    public static void main(String[] args) {
        List<MathOperation> myList = Arrays.asList(null, null);
        myList.forEach(m -> System.out.print(m.calculate(args[index++], 1, 2) + " "));

        // Function
        Function<String, Boolean> stringer = s -> Boolean.parseBoolean(s);
        Function<Boolean, String> booleaner = i -> Boolean.toString(i);

        // predicate :
        Predicate<String> p1 = s -> s.compareTo("C") > 0;
        Predicate<String> p2 = s -> s.equals("B");
        List<String> letters = new ArrayList(Arrays.asList("D", "B", "A", "C", "F", "G"));
        letters.removeIf(p1.negate().or(p2));
        letters.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println(letters);

        // compose and andThen   ( compose does first ,  andThen does later )
        Predicate<String> lengther = (s) -> s.length() < 2;
        Predicate<String> equalizer = Predicate.isEqual("car");
        System.out.println(stringer.compose(booleaner).apply(true));
        System.out.println(booleaner.compose(stringer).apply("true").substring(0, 3));
        System.out.println(booleaner.andThen(stringer).apply(true));
        System.out.println(lengther.negate().or(equalizer).test("CAR"));
        System.out.println(booleaner.apply(true));

        // supplier and consumer   :  consumer takes one element and no return, e.g. void , supplier returns 1 result
        Supplier<String> i = () -> "Car";
        Consumer<String> c = x -> System.out.print(x.toLowerCase());
        Consumer<String> d = x -> System.out.print(x.toUpperCase());
        c.andThen(d).accept(i.get());

        // BinaryOperator and BiFunction
        BiFunction<String, String, Integer> biFunction = (x, y) -> x.compareTo(y);
        biFunction.apply("cat", "dong");

        // max min etc reduce feature
        Stream.of("green", "yellow", "blue")
                .max((s1, s2) -> s1.compareTo(s2))
                .filter(Objects::nonNull)
                .filter(e -> e.endsWith("n"))
                .ifPresentOrElse(System.out::println, () -> System.out.println("blank:default:yellow"));
        Integer a = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10).stream()
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
        System.out.println(a);


    }

    static class MathOperation {
        static int calculate(String choice, int a, int b) {
            int c = 3;
            switch (choice) {
                case "ADD":
                    c += a + b;
                case "SUBTRACT":
                    c += a - b;
                default:
                    c += a * b;
            }
            return c;
        }
    }

}

