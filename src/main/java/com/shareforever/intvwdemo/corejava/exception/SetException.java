package com.shareforever.intvwdemo.corejava.exception;

import java.util.*;

/**
 * - Collection
 * -    Set
 * -    NavigaibleSet
 * -    SortedSet
 * -    TreeSet
 */
public class SetException {

    public static void main(String[] args) {
        hashSet();
        sortedSet();
    }

    private static void sortedSet() {
        SortedSet<Element> s = new TreeSet<Element>();
        s.add(new Element(15));
        s.add(new Element(10));
        s.add(new Element(25));
        s.add(new Element(10));
        //     This is a clever way to create the iterator and call iterator.hasNext() like
        //     you would do in a while-loop. It would be the same as doing:
        //     Iterator<String> iterator = list.iterator();
        //     while (iterator.hasNext()) {iterator.next();}
        for (Iterator<Element> it = s.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        Set<String> sortedSet = new TreeSet<>();
        sortedSet.add("2");
        sortedSet.add("4");
        sortedSet.add("5");
        sortedSet.add("3");
        sortedSet.add("1");
        sortedSet.forEach(System.out::println);  // even easier.
    }

    private static void hashSet() {
        /*
            HashSet doesn’t maintain any order, the elements would be returned in any random order.
            But as pointed out, "no guarantee of ordering" does not imply "guaranteed random ordering".
            it uses its internal hexilitteral sort to output ( hashing )
         */
        Set<String> set1 = new HashSet<>();
        set1.add("2");
        set1.add("1");
        set1.add("4");
        set1.add("5");
        set1.add("3");
        set1.forEach(System.out::println);
        System.out.println();

        Set orderredInInsertOrderSet = new LinkedHashSet(); // linked means inserted in order
        orderredInInsertOrderSet.add("2");
        orderredInInsertOrderSet.add("1");
        orderredInInsertOrderSet.add("4");
        orderredInInsertOrderSet.add("5");
        orderredInInsertOrderSet.add("3");
        orderredInInsertOrderSet.forEach(System.out::println);
        System.out.println();

        TreeSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("2");
        sortedSet.add("1");
        sortedSet.add("4");
        sortedSet.add("5");
        sortedSet.add("3");
        sortedSet.forEach(System.out::println);
        System.out.println();
    }

    static class Element implements Comparable {
        int id;

        Element(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Object obj) {
            Element e = (Element) obj;
            return this.id - e.id;
        }

        public String toString() {
            return "" + this.id;
        }
    }
}


