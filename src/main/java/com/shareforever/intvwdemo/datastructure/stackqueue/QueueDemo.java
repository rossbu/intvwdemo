package com.shareforever.intvwdemo.datastructure.stackqueue;

/**
 * Created by tbu on 6/25/2014.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tb088e
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("Hello");
        queue.offer("World ");
        queue.offer(" ross!");
        System.out.println("before poll queue size is :" + queue.size());
        String str;
        while ((str = queue.poll()) != null) {
            System.out.print(str);
        }
        System.out.println();
        System.out.println("after poll queue size is :" + queue.size());
    }
}

