package com.shareforever.intvwdemo.datastructure.linklist;


/*
    https://www.hackerrank.com/challenges/30-linked-list/problem

    Complete the insert function in your editor so that it creates a new Node (pass  as the Node constructor argument)
    and inserts it at the tail of the linked list referenced by the  parameter.
    Once the new node is added, return the reference to the  node.

    Note: If the  argument passed to the insert function is null, then the initial list is empty.

    Input Format

    The insert function has  parameters: a pointer to a Node named , and an integer value, .
    The constructor for Node has  parameter: an integer value for the  field.

    You do not need to read anything from stdin.

    Output Format

    Your insert function should return a reference to the  node of the linked list.

    Sample Input

    The following input is handled for you by the locked code in the editor:
    The first line contains T, the number of test cases.
    The  subsequent lines of test cases each contain an integer to be inserted at the list's tail.

    4
    2
    3
    4
    1

    Sample Output

    The locked code in your editor prints the ordered data values for each element in your list as a single line of space-separated integers:

    2 3 4 1
 */
public class InsertionLinkList {
    Integer anum = 1;


    /*
        https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public static void main(String args[]) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int len = array.length;
        int idx = 0;
        Node head = null;
        while (idx < len) {
            head = insertTailIterative(head, array[idx]);
            idx++;
        }
//        while( len--> 0) {
//            head = insert(head,array[len]);
//        }

        // Remove Nth Node From	End	of	List
//        removeNthNodeFromListWithKnownLength(head, 3, len);
//        removeNthNodeFromListWithoutDummyHead(head, 2);
//        removeNthNodeFromListWithDummyHead(head, 2);
        display(head);

    }


    static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    /*
        inserts it at the tail of the linked list referenced by the  parameter.
        Once the new node is added, return the reference to the  head node.
     */
    static Node insertTailRecursive(Node head, int data) {
        if (head == null) return new Node(data);
        head.next = insertTailRecursive(head.next, data);
        return head;
    }

    /* Appends a new node at the end.  This method is defined inside LinkedList class shown above */
    static Node insertTailIterative(Node head, int new_data) {

        // exit condition
        if (head == null) {
            head = new Node(new_data);
            return head;
        }

        // create the new node
        Node new_node = new Node(new_data);

        // create dummy node --> current head.
        Node dummy = new Node(99);
        dummy.next = head;

        // create a local pointer for head which is Optional  though
        Node current = head;

        // move the pointer to the end, and link the new node.
        while (current.next != null)
            current = current.next;
        current.next = new_node;

        // return dummy.next, which means the begining node
        return dummy.next;
    }


    /* Inserts a new Node at front of the list. */
    Node insertFront(Node head, int new_data) {
        Node new_node = new Node(new_data);

        /* 3. point to the old head -- means linkkkkking....*/
        new_node.next = head;  // at this moment, the head is POINTING to the old node in heap

        /* 4. current new node is the new head */
        head = new_node; // Now the head is pointing to the new node in heap ,n+1 nodes now

        return head;
    }


    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }


    /*
        when len is known , it's easy.
     */
    static void removeNthNodeFromListWithKnownLength(Node head, int len, int n) {
        int i = 1;
        int to = len - n - 1;
        while (i <= to) {
            head = head.next;
            i++;
        }
        head.next = head.next.next;
    }

    /*
            https://www.youtube.com/watch?v=Ny4YACv-skc
            slow fast pointer with dummy head
     */
    static void removeNthNodeFromListWithDummyHead(Node head, int n) {
        Node dummy = new Node(99);
        dummy.next = head;
        Node slow_pointer = dummy;
        Node fast_pointer = head;
        int i = 0;
        // move the fast pointer to the end
        while (fast_pointer.next != null) {
            fast_pointer = fast_pointer.next;
            i++;

            // move the slow pointer when i > n
            if (i >= n) {
                slow_pointer = slow_pointer.next;
            }
        }
        slow_pointer.next = slow_pointer.next.next;
    }


    /*
        NO length of the list,  remove the nth ele from end of list
        slow fast pointer tech
     */
    private static Node removeNthNodeFromListWithoutDummyHead(Node head, int n) {
        if (head.next == null) {
            return null;
        }
        int i = 0;
        Node p1 = head, p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            ++i;
            if (i > n) { // when i is over n, then start walking
                p2 = p2.next;
            }
        }
        if (i == n - 1) {
            head = head.next;
        } else {
            p2.next = p2.next.next;
        }
        return head;
    }
}
