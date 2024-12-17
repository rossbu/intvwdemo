package com.shareforever.intvwdemo.datastructure.stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.ArrayList;
    
public class QueueDemo {
    /**
     * The main method is the entry point of the program. It demonstrates the usage of a Queue
     * by adding elements to the queue, polling and printing them, and checking the size
     * before and after.
     *
     * @param args an array of command-line arguments
     */
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("Hello");
        queue.add("World ");
        queue.add(" ross!");
        System.out.println("before poll queue size is :" + queue.size());
        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
        }
        System.out.println();
        System.out.println("after poll queue size is :" + queue.size());
    }
      
    public Queue<String> convertArrayListToQueue(ArrayList arrayList) {
        Queue<String> queue = new ArrayDeque<>(arrayList);
        return queue;
    }
}