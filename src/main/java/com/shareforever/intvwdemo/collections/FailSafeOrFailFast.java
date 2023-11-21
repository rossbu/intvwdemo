package com.shareforever.intvwdemo.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/*
    https://www.javainterviewpoint.com/java-concurrenthashmap/
    ConcurrentHashMap	SynchronizedMap [Collections.synchronizedMap()]	HashTable
 */
public class FailSafeOrFailFast {
  /*
    Example : ConcurrentHashMap, CopyOnWriteArrayList
    Fail-safe iterators allow modifications of a collection while iterating over it.
    These iterators don’t throw any Exception if a collection is modified while iterating over it.
    They use copy of original collection to traverse over the elements of the collection.
    These iterators require extra memory for cloning of collection. Ex : ConcurrentHashMap, CopyOnWriteArrayList
    NO Extra memory needed but not guranteed
    Also, those collections which don’t use fail-fast concept may not necessarily create clone/snapshot of it in memory to avoid ConcurrentModificationException.
    For example, in case of ConcurrentHashMap, it does not operate on a separate copy although it is not fail-fast. Instead, it has semantics that is described by the official specification as weakly consistent(memory consistency properties in Java).
    Below code snippet will demonstrate this:

  */
  public static void main(String args[]) {
    failSafe_ConcurrentHashMap();
    failFast_ArrayList();
    failFast_HashMap();

    Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<Object, Object>());
  }

  private static void failFast_HashMap() {
    Map<String, String> cityCode = new HashMap<>();
    cityCode.put("Delhi", "India");
    cityCode.put("Moscow", "Russia");
    cityCode.put("New York", "USA");
    Iterator iterator = cityCode.keySet().iterator();

    while (iterator.hasNext()) {
      System.out.println(cityCode.get(iterator.next()));

      // adding an element to Map
      // exception will be thrown on next call
      // of next() method.
      cityCode.put("Istanbul", "Turkey");
    }
  }

  private static void failFast_ArrayList() {
    ArrayList<Integer> al = new ArrayList<>();
    al.add(1);
    al.add(2);
    al.add(3);
    al.add(4);
    al.add(5);

    Iterator<Integer> itr = al.iterator();
    while (itr.hasNext()) {
      if (itr.next() == 2) {
        // will not throw Exception
        itr.remove();
      }
    }

    System.out.println(al);

    itr = al.iterator();
    while (itr.hasNext()) {
      if (itr.next() == 3) {
        // will throw Exception on next call of next() method
        al.remove(3);
      }
    }
  }
  private static void failSafe_ConcurrentHashMap() {
    CopyOnWriteArrayList<Integer> list =
        new CopyOnWriteArrayList<Integer>(new Integer[] {1, 3, 5, 8});
    Iterator itr = list.iterator();
    while (itr.hasNext()) {
      Integer no = (Integer) itr.next();
      System.out.println(no);

      if (no == 8)

        // This will not print,
        // hence it has created separate copy
        list.add(14);
    }
  }

}
