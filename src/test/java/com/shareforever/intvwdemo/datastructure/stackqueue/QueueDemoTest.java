package com.shareforever.intvwdemo.datastructure.stackqueue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * QueueDemoTest class.
 * 
 * It contains the tests for the method convertArrayListToQueue from the QueueDemo class.
 */
public class QueueDemoTest {

    /**
     * Some tests for the convertArrayListToQueue method.
     */
    @Test
    public void testConvertArrayListToQueue() {

        // Instantiate the class that contains the method to test
        QueueDemo queueDemo = new QueueDemo();
                
        // Initialize an ArrayList for testing
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("element 1");
        arrayList.add(2);
        arrayList.add(null); // testing null value
        
        // Call the method to test
        Queue<String> queue = queueDemo.convertArrayListToQueue(arrayList);
        
        // Check that the queue size is the same as the original ArrayList size
        assertEquals(arrayList.size(), queue.size(), "The queue size should be equals to the original ArrayList size");

        // Check that the queue front element is equals to the first element of the ArrayList
        assertEquals(arrayList.get(0), queue.peek(), "The queue front element should be equals to the first element of the ArrayList");

    }
}