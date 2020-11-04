package com.shareforever.intvwdemo.datastructure.stackqueue;

import java.util.PriorityQueue;

public class PriorityQueueTest {


    /*
        Printing out the PriorityQueue using the System.out.println command will not print the queue the order in which they were added.
        But when the remove() method is used to remove an object from the PriorityQueue, the object is removed on priority basis.
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> intQ = new PriorityQueue<>();

        intQ.add(51);
        intQ.offer(6);
        intQ.add(72);
        intQ.add(1);
        intQ.add(2);
        intQ.offer(3);
        intQ.offer(4);
        intQ.add(11);
        intQ.add(19);

        System.out.println("Elements in this queue are: ( sorted in nature order) ");
        System.out.println(intQ);

        // printing size of the queue
        System.out.println("Size of this queue is: " + intQ.size());

        // removing values based on priority and printing them
        System.out.println("Priority Queue:");
        while (!intQ.isEmpty()) {
            System.out.println(intQ.poll()); // poll == remove  add == offer
        }
    }

}

