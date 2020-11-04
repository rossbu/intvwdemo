package com.shareforever.intvwdemo.datastructure.linklist;

import java.util.LinkedList;
import java.util.Queue;

/*
    LinkedLIst implements ----  LIST and QUEUE
 */
public class LinkedListTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("first element");
        queue.offer("second element");
        queue.offer("third element");
        queue.offer("fourth. element");
        queue.offer("fifth. element");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        System.out.println("-------  List interface -------");
        Queue<String> listFeature = new LinkedList<String>();
        listFeature.add("first element");
        listFeature.add("second element");
        listFeature.add("third element");
        listFeature.add("fourth. element");
        listFeature.add("fifth. element");

        listFeature.clear();
    }
}
