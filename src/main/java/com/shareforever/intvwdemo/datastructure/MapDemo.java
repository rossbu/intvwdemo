package com.shareforever.intvwdemo.datastructure;

import java.util.*;
import java.util.concurrent.*;


/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#toMap-java.util.function.Function-java.util.function.Function-
 * <p>
 * Map
 * HashTable     ( thread safe , synchronized, but slow , not ordered )
 * HashMap       ( most used, not thread-safe , no synchronized, not ordered, alloed one null key, allow multi-null values )
 * LinkedHashMap ( Ordered by insertion: preserve insertion order , not sorted)
 * TreeMap       ( Sorted by key:  on red-black tree structure, and it is ordered by the key. )
 * ConcurrentHashMap ( thread-safe )
 * <p>
 * Note: if data structure supports synchronization, then nulls ( value and key) are NOT allowed,
 * such as:  hashtable, concurrentHashmap ( NULL is not an Object)
 * then HashMap and TreeMap allows Null
 */
public class MapDemo {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Geeks", "FOR", "GEEKSQUIZ", "Computer", "Science", "gfg");

        // Using Stream map(Function mapper) and displaying the length of each String
//        list.stream()
//                .filter(e-> e!=null)
//                .map(Book::getId)
//                .collect(Book::new, Book::takeId, Book::takeme);

//
//        MapDemo hashTableDemo = new MapDemo();
//        hashTableDemo.hashTable();
//        hashTableDemo.hashMap();
//
//        // 1. show 3 ways to create synchronized map:  natural hashtable, Collections.synchronizedMap, ConcurrentHashMap
//        Map<String, String> normalMap = new Hashtable<String, String>();
//        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<String, String>());
//        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
//        System.out.println("Show cases for ConcurrentMap > synchronizedMap > Hashtable");
//
//        // mergefunction in toMap
//        // two Orders with the same code but different quantity of products for each one, and your desire is sum the quantities.
//        List<Order> listOrders = new ArrayList<>();
//        listOrders.add(new Order("COD_1", 1L));
//        listOrders.add(new Order("COD_1", 5L));
//        listOrders.add(new Order("COD_1", 3L));
//        listOrders.add(new Order("COD_2", 3L));
//        listOrders.add(new Order("COD_3", 4L));
//        listOrders.stream().collect(Collectors.toMap(Order::getCode,
//                o -> o.getQuantity(),
//                (o1, o2) -> o1 + o2)); // merge/sum 1L, 5L, 3L for the same key COD_1

    }


    static class Order {
        private String code;
        private float quantity;

        public Order(String cod_1, long l) {
            this.code = cod_1;
            this.quantity = l;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public float getQuantity() {
            return quantity;
        }

        public void setQuantity(float quantity) {
            this.quantity = quantity;
        }
    }

    /**
     * java.util.HashTable
     * <p>
     * Non-null key : throw exception
     * Non-null value : throw exception
     * Synchronized:
     * public synchronized void put(k,v)
     */
    public void hashTable() {
        System.out.println("\nhashTable testing...");
        Hashtable<Integer, String> map = new Hashtable<Integer, String>();
        map.put(101, "bu1");
        map.put(102, "bu2");
        map.put(103, "bu3");
        map.put(104, "bu4");
        map.put(101, "newbu");
        map.putIfAbsent(105, "bu5");

        try {
            // both throws NPE since hashtable use synchronization, so you can't put null on either key or value.
            map.put(null, "somevalue");
            map.put(107, null);
        } catch (NullPointerException e) {
            e.printStackTrace(); // you see exception here
        }
        System.out.println("new map" + map);
        System.out.println(map.getOrDefault(101, "Not Found"));
        System.out.println(map.getOrDefault(106, "Not Found"));
    }

    /**
     * java.util.HashMap
     * <p>
     * null as key
     * null as value
     * Not synchronized internally  ( but you can use Collections.syn... to help )
     * Not safe
     * exception: concurentHashMap does NOT allow null,null as either key or value.
     */
    public void hashMap() {
        int nThreads = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

        // normal map
        System.out.println("\nnormalMap testing...");
        Map<String, String> normalMap = new HashMap<>();
        normalMap.put(null, "normalnull");
        normalMap.put("key1", null);
        normalMap.put("key2", "value2");

        // synchronized map : iterator needs extra sync block
        System.out.println("\nsyncrhonizedMap testing...");
        Map<String, String> newSynchronizedMap = Collections.synchronizedMap(new HashMap<String, String>());
        Map<String, String> synchronizedMap = Collections.synchronizedMap(normalMap);// we can use existing map to operate as well , also insert/delete on normalmap
        synchronizedMap.put(null, "synchronizedNull");
        for (int i = 0; i < nThreads; i++) {
            executorService.submit(() -> {
                Thread currentThread = Thread.currentThread();
                String uuid = UUID.randomUUID().toString();
                synchronizedMap.put(uuid, uuid + "-v");
                String value = synchronizedMap.get(uuid);
                System.out.println(currentThread + " and value: " + value);
            });
        }


        /*
            concurrentMap
            key might be deleted by concurrent operations on the concurrentHashmap
         */
        System.out.println("\nconcurrentMap testing...");
        HashMap hashMap = new HashMap();
//        hashMap.put(null,"bu");     this will not work, concurrentMap doesn't allow null, can't be synchronized.
//        hashMap.put("key1", null);  this will not work, concurrentMap doesn't allow null, can't be synchronized.
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put("key4", "value4");
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(hashMap);

        Callable<String> addFile = () -> {
            System.out.println(Thread.currentThread() + " : Add file1.txt");
            Thread.sleep(2000);
            concurrentHashMap.put("filename", "file1.txt");
            return "file1.txt";
        };
        Callable<String> addUsername = () -> {
            System.out.println(Thread.currentThread() + " : Add file2.txt");
            Thread.sleep(2);
            concurrentHashMap.put("filename2", "file2.txt");
            return "tbu";
        };
        Callable<String> addTokens = () -> {
            System.out.println(Thread.currentThread() + " : Add file3.txt");
            Thread.sleep(3);
            concurrentHashMap.put("filename3", "file3.txt");
            // now let's try to  hashmap
            return "anewToken";
        };
        Callable<String> computeDigitalToken = () -> {
            System.out.println(Thread.currentThread() + " : Add file4.txt");
            Thread.sleep(4);
            concurrentHashMap.compute("digitalToken", (key, value) -> key + "-" + value + "-appendiix");
            // now let's try to  hashmap
            return "anewToken";
        };
        Callable<String> removeKey3 = () -> {
            System.out.println(Thread.currentThread() + " : Add new file3.txt");
            concurrentHashMap.put("filename3", "anewfile3.txt");
            return "removed";
        };


        // create a list callable ( return value)  lambda and put in list to be invoked all by executorSevice
        List<Callable<String>> listOfTasks = new ArrayList<>();
        listOfTasks.add(addFile);
        listOfTasks.add(addUsername);
        listOfTasks.add(addTokens);
        listOfTasks.add(computeDigitalToken);
        listOfTasks.add(removeKey3);
        try {
            executorService.invokeAll(listOfTasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // shut down and wait for all tasks completion
        executorService.shutdown();
        try {
            executorService.awaitTermination(nThreads, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("normalMap  : " + normalMap);
        System.out.println("synchronizedMap ( wrapper of normalMap )  : " + synchronizedMap);
        System.out.println("concurrentHashMap: " + concurrentHashMap);


    }
}
