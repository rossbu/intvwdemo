package com.shareforever.intvwdemo.collections;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;


/*
Collectors.toCollection
Collectors.toSet
Collectors.toMap
Collectors.toList

 */
public class CollectorsTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl", "cat", "cat", "dog", "dog", "dog");
        int[] nums = {61, 34, 45, 21, 11, 456, 22};
        int[] students = {-1, -3, -3, 4, 2, 2};
        String test = "Am I a cat or sth else";

        reducing(students, test.split(" "));
        counting(students, 2);
        groupingBy(strings);
        superGroupingBy();
        toCollection(nums);
        partitionBy(nums);
        toList(strings);
        joining(strings);

    }

    /*
        Collectors.reducing( a, b, c) :  explanation
        The first one is an identity. When reducing a stream, you have to start somewhere (otherwise, what would be the result of reducing an empty list?).
        The identity is the object applied to the first argument of the first reduction operation in the chain

        The second one is a mapper. reducing() is a generalized operation - you can reduce elements of a stream of type T into a final result of type U,
        so you have to give an intermediate operation that provides a type U element from a type T element.
        If T == U and you don't want a transformation, you can provide an identity function here

        The third argument is the reduction function - this is the one applied to elements of the stream in sequence, starting from the identity

        e.g.
        Collectors.reducing(0, x -> x, (x, y) -> x + y)   : sum
        Collectors.reducing(0, String::length, (x, y) -> x + y).


        https://www.logicbig.com/how-to/code-snippets/jcode-java-8-streams-collectors-reducing.html

        <T> Collector<T,?,Optional<T>> reducing(BinaryOperator<T> op)  -- 1 parameter

        <T> Collector<T,?,T> reducing(T identity,
                                        BinaryOperator<T> op)  -- 2 parameters

        <T,U> Collector<T,?,U> reducing(U identity,
                                    Function<? super T,? extends U> mapper,
                                    BinaryOperator<U> op)  -- 3 parameters

        https://www.logicbig.com/how-to/code-snippets/jcode-java-8-streams-collectors-reducing.html   -- with 3 good examples
     */
    private static void reducing(int[] a, String[] strs) {

        // use sum and initial value of sum result
        int withStartingValue = IntStream.of(a).reduce(2, Integer::sum);  // 2 more
        System.out.println("starting at 2, the sum is :" + withStartingValue);

        withStartingValue = Arrays.stream(a).reduce(Integer::sum).orElse(-1);

        // use sum directly on int
        int sum1 = IntStream.of(a).sum();

        // use Collectors.reducing
        int sum2 = IntStream.of(a)
                .boxed()
                .collect(Collectors.reducing(0, e -> e, (x, y) -> x + y));
        System.out.println("reducing to sum : " + sum2);

        // 1 parameter -  BinaryOperator, but remember it returns Optional
        Optional<Integer> optionalInteger = IntStream.of(a)
                .boxed()
                .collect(Collectors.reducing((x, y) -> x + y));

        // 2 parameters ( identity as starting point, binaryoperator )
        String newStrs = Stream.of(strs)
                .collect(Collectors.reducing("", (x, y) -> x + y));
        System.out.println("reducing to by concating all strings :" + newStrs);

        // 3 parameters ( identity, mapper, BinaryOperator), 2nd mapper converts String -> int  ( T -> U )  , then 3rd one applys each int with plus ( x+y)
        int lengthSum = Stream.of(strs)
                .collect(Collectors.reducing(0, String::length, (x, y) -> x + y));
        System.out.println("reducing to String length and then sum : " + lengthSum);


        // 1 2 3  parameters demo
        Integer i1 = Stream.of(5, 10, 20, 50).collect(Collectors.reducing((x, y) -> x - y)).orElse(-1);
        Integer i2 = Stream.of(5, 10, 20, 50).collect(Collectors.reducing(1,
                (integer, integer2) -> integer2 * integer));
        String i3 = Stream.of(5, 10, 20, 50).collect(Collectors.reducing(
                "",
                x -> Integer.toString(x),
                (s1, s2) -> s1 + s2));
    }

    /*
        please use 3 different collecting ways to return the qualified elements

        count()
        Collectors.counting()
        Collectors.groupingBy(a,b)
        Collectors.groupingBy

     */
    private static String counting(int[] a, int k) {
        long onTimeStudents = 0L;
        int intNumOfStudents = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        {  // use filter.count
            onTimeStudents =
                    IntStream.of(a).boxed()
                            .filter(e -> e <= 0)
                            .count();
        }

        { // use collect.Collectors.counting() is equivalent to count();
            onTimeStudents =
                    IntStream.of(a).boxed()
                            .filter(e -> e <= 0)
                            .collect(Collectors.counting());
        }

        { // use collect.collectors.reducing (0, e->1,Integer::sum) to collect int value instead of long
            intNumOfStudents =
                    IntStream.of(a).boxed()
                            .filter(e -> e >= 0)
                            .collect(Collectors.reducing(0, e -> 1, Integer::sum));
        }

        { // group the student per on-time or late-time
            Map<Integer, Long> map = IntStream.of(a).boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println("groupingBy: " + map.toString());
        }

        return "wow";
    }

    private static void partitionBy(int[] nums) {
        Map<Boolean, List<Integer>> map = IntStream.of(nums).boxed().collect(Collectors.partitioningBy(e -> e > 50));
        System.out.println("Map >50 :" + map);
        Map<Boolean, Long> mapCounting = IntStream.of(nums).boxed().collect(Collectors.partitioningBy(e -> e > 50, Collectors.counting()));
        System.out.println("Map >50 :" + mapCounting);
    }

    static void toCollection(int[] nums) {
        HashSet hashset = IntStream.of(nums).boxed().distinct().collect(Collectors.toCollection(HashSet::new));
        TreeSet treeSet = IntStream.of(nums).boxed().distinct().collect(Collectors.toCollection(TreeSet::new));

        String[] strs = new String[]{"a1", "a22", "b"};
        Set<String> set = Stream.of(strs).collect(Collectors.toSet());
        Vector<String> vector = Stream.of(strs).collect(Collectors.toCollection(Vector::new));
        List<String> list = Stream.of(strs).collect(Collectors.toCollection(ArrayList::new));
        Stack<String> stack = Stream.of(strs).collect(Collectors.toCollection(Stack::new));
        TreeSet<String> queue = Stream.of(strs).collect(Collectors.toCollection(TreeSet::new));
        TreeMap<String, Integer> map = Stream.of(strs).collect(Collectors.toMap(e -> e, e -> e.length(), (e1, e2) -> e1, TreeMap::new));


        Stream<String[]>
                Ss1 = Stream
                .of(new String[][]{{"GFG", "GeeksForGeeks"},
                        {"g", "geeks"},
                        {"GFG", "Geeks"}});

        // Get Map from String
        // using toMap() method
        LinkedHashMap<String, String>
                map2 = Ss1
                .collect(Collectors
                        .toMap(
                                p -> p[0], p -> p[1], (s, a) -> s + "-" + a, LinkedHashMap::new));

        // Print the Map
        System.out.println("Map:" + map2);
    }


    /**
     * https://codereview.stackexchange.com/questions/140290/calculate-fractions-of-positive-negative-and-zeros
     */

    static void superGroupingBy() {
        DecimalFormat df = new DecimalFormat("##0.000000");
        final Integer POSITIVE_KEY = 1;
        final Integer NEGATIVE_KEY = -1;
        final Integer ZERO_KEY = 0;
        Integer[] array = {-4, 3, -9, 0, 4, 1};

        Map<Integer, Long> result =
                Stream.of(array)
                        .collect(Collectors.groupingBy(i -> i > 0 ? POSITIVE_KEY : i < 0 ? NEGATIVE_KEY : ZERO_KEY,
                                Collectors.counting()));
        double total = (double) result.values().stream().mapToLong(l -> l).sum();
        System.out.println(df.format(result.getOrDefault(POSITIVE_KEY, 0l) / total));
        System.out.println(df.format(result.getOrDefault(NEGATIVE_KEY, 0l) / total));
        System.out.println(df.format(result.getOrDefault(ZERO_KEY, 0l) / total));
    }

    private static void groupingBy(List<String> strings) {
        strings.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                .forEach(
                        (e1, e2) -> System.out.println(String.format("%s : %s", e1, e2))
                );
    }

    private static void toList(List<String> strings) {
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
    }

    private static void joining(List<String> strings) {
        String mergedString = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining(", "));
        System.out.println("Joined String: " + mergedString);
    }
}
