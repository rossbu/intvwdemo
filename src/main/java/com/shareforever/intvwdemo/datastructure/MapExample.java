package com.shareforever.intvwdemo.datastructure;

import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

import java.util.*;
import java.util.Map.Entry;

/**
 * http://mrbool.com/overview-of-java-arraylist-hashtable-hashmap-hashetlinkedlist/30383
 * <p>
 * term:
 * Linked : keep order they are inserted
 */
public class MapExample {

    public static void main(String args[]) {


        //creating Hashtable for sorting
        Map<String, Integer> mapfortest = new HashMap<String, Integer>();
        mapfortest.put("England", 3);
        mapfortest.put("USA", 1);
        mapfortest.put("China", 2);
        mapfortest.put("Russia", 4);

        //printing hashtable without sorting
        System.out.println("Unsorted Map in Java : " + mapfortest);

        //sorting Map e.g. HashMap, Hashtable by keys in Java
        Map<String, Integer> sorted = sortByKeys(mapfortest);
        System.out.println("Sorted Map in Java by key: " + sorted);

        //sorting Map like Hashtable and HashMap by values in Java
        sorted = sortByValues(mapfortest);
        System.out.println("Sorted Map in Java by values: " + sorted);

        //Sorting Map in Java by keys using TreeMap ( Default sorting by natural order)
        Map<String, Integer> sortedMapByKeys = new TreeMap<String, Integer>();
        sortedMapByKeys.putAll(mapfortest);
        System.out.println("Sorted Map in Java by key using TreeMap : " + sortedMapByKeys);

        //Sorting Map by keys in Java using Google Collections (Guava)
        //Main benefit is you can specify any ordering like natural or toString or arbitrary
        Map<String, Integer> sortingUsingGuava = Maps.newTreeMap(Ordering.natural());
        sortingUsingGuava.putAll(mapfortest);
        System.out.println("Example to sort Map in Java using Guava : " + sortingUsingGuava);

    }

    public static <k extends Comparable, v extends Comparable> Map<k, v> convertMap(Map<k, v> map) {
        Set<k> ks = map.keySet();
        List<k> keysInLinkedList = new java.util.LinkedList(ks); // linked means ordered but may not be sorted
        Collections.sort(keysInLinkedList);

        Map<k, v> linkedMap = new LinkedHashMap<k, v>();
        for (k key : keysInLinkedList) {
            linkedMap.put(key, map.get(key));
        }
        return null;
    }

    /*
     * Paramterized method to sort Map e.g. HashMap or Hashtable in Java
     * throw NullPointerException if Map contains null key
     */
    public static <K extends Comparable, V extends Comparable> Map<K, V> sortByKeys(Map<K, V> map) {
        List<K> keys = new java.util.LinkedList<K>(map.keySet());
        Collections.sort(keys);

        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K, V> sortedMap = new LinkedHashMap<K, V>();
        for (K key : keys) {
            sortedMap.put(key, map.get(key));
        }

        return sortedMap;
    }

    /*
     * Java method to sort Map in Java by value e.g. HashMap or Hashtable
     * throw NullPointerException if Map contains null values
     * It also sort values even if they are duplicates
     */
    public static <K extends Comparable, V extends Comparable> Map<K, V> sortByValues(Map<K, V> map) {
        List<Map.Entry<K, V>> entries = new java.util.LinkedList<Map.Entry<K, V>>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {

            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K, V> sortedMap = new LinkedHashMap<K, V>();

        for (Map.Entry<K, V> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

}
