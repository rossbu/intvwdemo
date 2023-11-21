package com.shareforever.intvwdemo.problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/*
  https://www.techiedelight.com/implement-multimap-java/
 */
public class MultiMapCustom {
  public static void main(String[] args) {
    // create a multimap from past US presidents list
    MultiMap<String, String> multimap = new MultiMap();

    multimap.put("Zachary", "Taylor");
    multimap.put("John", "Adams");
    multimap.put("John", "Tyler");
    multimap.put("John", "Kennedy");
    multimap.put("George", "Washington");
    multimap.put("George", "Bush");
    multimap.put("Grover", "Cleveland");

    System.out.println("----- Printing Multimap using keySet -----\n");
    for (String lastName: multimap.keySet()) {
      System.out.println(lastName + ": " + multimap.get(lastName));
    }

  }


  static class MultiMap<K, V> {
    private Map<K, Collection<V>> map = new HashMap<>();

    public void put(K key, V value) {
      if (map.get(key) == null) {
        map.put(key, new ArrayList<V>());
      }
      map.get(key).add(value);
    }

    public void putIfAbsent(K key, V value) {
      if ( map.get(key) ==  null) {
        map.put(key, new ArrayList<V>());
      }
      if (!map.get(key).contains(value)) {
        map.get(key).add(value);
      }
    }


    /*
        Set[0]    Entry 0
        Set[1]    Entry 1

        Entry

     */
    public Set<Map.Entry<K, Collection<V>>> entrySet() {
      return map.entrySet();
    }
    public Collection<V> get(K key)  {
      return map.get(key);
    }

    public Set<K> keySet(){
      return map.keySet();
    }

    public Collection<Collection<V>> values(){
      return map.values();
    }



  }
}
