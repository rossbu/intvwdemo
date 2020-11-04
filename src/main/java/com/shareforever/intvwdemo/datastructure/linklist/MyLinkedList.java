package com.shareforever.intvwdemo.datastructure.linklist;

import java.util.HashSet;


/*
    Detect loop in a linked list
    Remove duplicate from sorted or unsorted linkedList

 */
public class MyLinkedList {

    Node head;

    /* Linked list Node*/
    static class Node {  // static or non-static should be fine
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {

        // sorted
        MyLinkedList llist = new MyLinkedList();
        llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(11);
        llist.push(11);
        llist.removeDuplicatesFromSortedList();
        llist.display();

        // unsorted
        llist = new MyLinkedList();
        llist.push(15);
        llist.push(15);
        llist.push(13);
        llist.push(17);
        llist.push(17);
        llist.push(18);
        llist.push(11);
        llist.push(12);
        llist.push(11);
//        llist.removeDuplicateFromUnSortedListByBuffer();
        llist.removeDupsNotUsingBuffer();
        llist.display();

    }

    /* Function to print linked list */
    void display() {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. point to the old head -- means linkkkkking....*/
        new_node.next = head;  // at this moment, the head is POINTING to the old node in heap

        /* 4. current new node is the new head */
        head = new_node; // Now the head is pointing to the new node in heap ,n+1 nodes now
    }

    // 11,11,11,13,13,14  : easy
    private void removeDuplicatesFromSortedList() {
        Node curr = head;

        while (curr != null) {
            Node temp = curr;
            while (temp != null && curr.data == temp.data) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
    }

    /*
    https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
     */
    private void removeDuplicateFromUnSortedListByBuffer() {
        Node curr = head;
        Node prev = null;
        HashSet<Integer> seenVals = new HashSet();
        while (curr != null) {
            if (seenVals.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                seenVals.add(curr.data);
                prev = curr;  // also init this node ( 1st value)
            }
            curr = curr.next;
        }
    }

    void removeDupsNotUsingBuffer() {
        Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;

        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;

            /* Compare the picked element with rest
                of the elements */
            while (ptr2.next != null) {

                /* If duplicate then delete it */
                if (ptr1.data == ptr2.next.data) {

                    /* sequence of steps is important here */
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else /* This is tricky */ {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }
}
