package com.shareforever.intvwdemo.problem;


import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.util.*;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * https://www.programcreek.com/2014/05/leetcode-top-k-frequent-elements-java/
 * <p>
 * Q:  find k most frequent words
 * input:      "cat dog cat cat dog fish dog frog fish bird cat"  AND K = 3
 * output:     cat : 4 ; dog 3 ; fish  2
 */
public class MostFrequentWords {
    public static void main(String[] args) {
        String str = "cat cat dog cat cat dog fish dog frog fish bird cat";
        int kmost = 3;
//        solution(str, 4);
//        solution2(str, 3);
//        solution3(str,3);
//        solution4(str,kmost );
//        solution5(str); // only find the most frequent elements from array
//        solution6(str, kmost);
        tryme(str, 2);
        wordFreqV2();
    }

    /*
     return the kth most frequent word in th str which is separated by ' '
     */

    public static String tryme(String str, int kthIndex) {
        String kthElement = "";
        String ans= "N/A";  //  for some reason, not found.

        // exception
        if (str == null || str.length() == 0) return str;

        if ( kthIndex == 0 ) return "_";

        // put str into string[]
        String[] words = str.split(" ");

        // put [ word, frequency ] in Map
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        // sort entries in list<Entry>
        LinkedList<Map.Entry<String,Integer>> list = new LinkedList(map.entrySet());
        Collections.sort(list, (e1,e2) -> e2.getValue() - e1.getValue());

       // skip kth-1
        ans  = list.stream().skip(kthIndex-1)
                .findFirst().get().getKey();

        System.out.println(ans);

        return ans;



    }

    public static void wordFreqV3() {
        String text = "Ann while Bob had had had had had had had had had had had a better effect on on the teacher";
        ConcurrentMap<String, Integer> freqMap =
                asList(text.split("[\\s.]"))
                        .parallelStream()
                        .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        System.out.println(freqMap.toString());
    }

    public static void wordFreqV2() {
        String text = "Ann while while bob Bob had had had had had had had had had had had a better effect on on the teacher";
        Map<String, Integer> freqMap = new HashMap<>();
        List<String> list = asList(text.split("[\\s.]"));
        list.forEach(s -> {
            freqMap.compute(s, (k, v) -> v == null ? 1 : v + 1);
        });
        System.out.println(freqMap.toString());
    }

    public static void textWordFreqV1() {
        String text = "Ann while Bob had had had had had had had had had had had a better effect on on the teacher";
        ConcurrentMap<String, Integer> freqMap =
                asList(text.split("[\\s.]"))
                        .parallelStream()
                        .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        System.out.println(freqMap.toString());

        //Priority queue that uses frequency as the comparator and size as 3
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
        for (String key : freqMap.keySet()) {
            pq.add(key);
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        System.out.println("Top 3 words by occurrences  : " + pq);
    }

    private static void solution6(String str, int kmost) {
        List<String> list = asList(str.split(" "));
        Objects.<Map.Entry<String, Integer>>compare(null, null, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(kmost)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new))
                .forEach((e1, e2) -> {
                    System.out.println(e1 + " : " + e2);
                });
    }


    private static void solution5(String str) {
        asList(str.split(" ")).stream()
                .collect(groupingBy(e -> e, counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(e -> e.getValue()))
                .ifPresentOrElse(System.out::println, () -> System.out.println("sth is rong"));
    }

    private static void solution4(String str, int kmost) {
        // covert str to a array of string
        String[] arr = str.split(" ");
        asList(arr).stream()
                .collect(groupingBy(e -> e, counting()))
                .entrySet()
                .stream()
                .sorted(Entry.<String, Long>comparingByValue().reversed())
                .limit(kmost)
                .collect(toMap(Map.Entry::getKey, e -> e.getValue().intValue(), (e1, e2) -> e1, LinkedHashMap::new))
                .forEach((e1, e2) -> System.out.println(e1 + ": " + e2));
    }

    private static void solution3(String str, int kmost) {
        List<String> list = asList(str.split(" "));

        // Map [ word - frequency ]
        Map<String, Integer> unsortedMap = doFrequency(list);

        // sort the map by value
        List<Entry<String, Integer>> linkedList = doSortByValue(unsortedMap);

        // print k-most frequent words
        for (int i = 0; i < kmost; i++) {
            System.out.println(linkedList.get(i));
        }
    }

    /**
     * Note:  Map-entrySet means return a Set of Entry(key,value): Consider HashMap as just an array of objects.
     * e.g:
     * Entry(key1,value1)
     * Entry(key2,value2)
     * Entry(key3,value3)
     * ...
     *
     * @param list
     * @return
     */
    private static Map<String, Integer> doFrequency(List<String> list) {
        Map<String, Integer> newmap;

        fre1:
        {
            // https://www.logicbig.com/how-to/code-snippets/jcode-java-8-streams-collectors-toconcurrentmap.html
            // keymapper,valuemappr,mergefunction, mapsupplier (function to create a new instance of map darta structure
            newmap = list.stream().collect(toMap(k -> k, v -> 1, Integer::sum, LinkedHashMap::new));
        }

        fre2:
        // use stream collect groupingBy ( key, counting() )
        {
            // https://www.logicbig.com/how-to/code-snippets/jcode-java-8-streams-collectors-groupingby.html
            Map<String, Long> tempMap = list.stream().collect(groupingBy(Function.identity(), counting()));
            newmap = tempMap.entrySet().stream().collect(toMap(
                    e -> e.getKey(), e -> e.getValue().intValue()
            ));
        }
        return newmap;
    }


    private static List<Entry<String, Integer>> doSortByValue(Map<String, Integer> map) {
        Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> linkedList = new LinkedList(set);
        Collections.sort(linkedList, (k, v) -> {
            return k.getValue().compareTo(v.getValue());
        });
        Collections.reverse(linkedList);
        return linkedList;
    }


    private static void solution2(String str, int num) {

        String[] strArr = str.split(" ");
        ArrayList<String> arrayList = Lists.newArrayList(strArr);
        System.out.println(arrayList.size());
        Map<String, Long> map = arrayList.stream()
                .collect(groupingBy(Function.identity(), counting()));

        // me try
        Map<String, Long> sortedMap = map.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .collect(toMap(Entry::getKey, Entry::getValue));

        // others try
        LinkedHashMap<String, Long> countByWordSorted = map.entrySet()
                .stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(toMap(
                        Entry::getKey,
                        Entry::getValue,
                        (v1, v2) -> {
                            throw new IllegalStateException();
                        },
                        LinkedHashMap::new
                ));

        // print
        System.out.println(countByWordSorted);
    }

}
