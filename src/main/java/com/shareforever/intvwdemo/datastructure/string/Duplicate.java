package com.shareforever.intvwdemo.datastructure.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Duplicate {

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4, 4, 6, 6};
        String input = "I am a cat cat and a cat fish fish fish dog dog dog dog dog dog";

        // try me
        long start = System.nanoTime();
        String[] words = input.split("\\s+");
        List<String> listOfWords = Arrays.asList(words);
        Map<String,Long> wordsFrequencyMap = new HashMap<>();
        for ( String s : words){
            int frequency = Collections.frequency(listOfWords,s);
            wordsFrequencyMap.putIfAbsent(s,(long)frequency);
        }

        LinkedHashMap<String, Long> ans = wordsFrequencyMap.entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));

        long end = System.nanoTime();
        long timeElapsed = (end - start) / 1_000_000_000;
        System.out.println("Time elapsed : " + timeElapsed + " s");
        assert( timeElapsed > 0);
        Objects.requireNonNull(args);


        countDuplicate(input);
        removeDuplicate(input);




        Map<String, Integer> map = collectDuplicate(input);
        printMap(map);
    }


    /*
        1, use Collectors.toMap(keymapper, valuemapper,mergefunctiohn,Asupplier) to calculate frequency
        2, use Collectors.toMap(keymapper,valuemapper,mergefunction,LinkedHashMap::new) to return LinkedHashMap<String,Integer>

        Note: may use filter to filter any value of entryset less|equal 1

            keyMapper:
                A mapping function to produce the map keys for each input stream element.

            valueMapper:
                A mapping function to produce the map values for each input stream element.

            mergeFunctionforSameKeyValueResovler: (optinal )
                A binary operator which is to resolve collisions between values associated with the same key.
                The inputs to this function are the values which belong to the same key.
                Using BinaryOperator we can merge the values of duplicate keys.
                if there are duplicate keys without merge, it will throw IllegalStateException.

            mapSupplier: ( optional )
                A function which provides a new instance of the desired implementation of the Map.
                default supplier will return HashMap. we need to pass supplier as LinkedHashMap::new if we need to main the order.
     */
    private static void countDuplicate(String s) {
        // edge corner cases
        // put string into array
        String[] words = s.split("\\s+");

        // with all 4 arguments
        LinkedHashMap<String, Integer> collect = Stream.of(words).collect(Collectors.toMap(w -> w, w -> 1, Integer::sum, LinkedHashMap::new))
                .entrySet().stream()
                .filter(o -> o.getValue() >1)
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(collect.toString());

        // without supplier, it will return Interface Map instead of LinkedHashMap
        Map<String, Integer> withoutSupplier = Stream.of(words).collect(Collectors.toMap(w -> w, w -> 1, Integer::sum, LinkedHashMap::new))
                .entrySet().stream()
                .filter(o -> o.getValue() > 1)
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1));
        System.out.println("withoutSupplier" + withoutSupplier.toString());

        // without supplier, without merge, it will return Interface Map instead of LinkedHashMap
        Map<String, Integer> withoutSupplierAndMerge = Stream.of(words).collect(Collectors.toMap(w -> w, w -> 1, Integer::sum, LinkedHashMap::new))
                .entrySet().stream()
                .filter(o -> o.getValue() > 1)
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        System.out.println("withoutSupplierAndMerge: "+ withoutSupplierAndMerge.toString());

        // throw exception if there is no merge for collsion of keys
        Stream.of(words).collect(Collectors.toMap(w -> w, w -> 1));
    }
    /*
        put in map (word, frequency)
        sort by entrySet ( value )
     */
    static int countDupplicate2(String s) {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        String[] words = s.split("\\s+");
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        LinkedHashMap<String, Integer> collect = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue(), (k, v) -> k, LinkedHashMap::new));
        System.out.println(collect.toString());
        return 1;
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
