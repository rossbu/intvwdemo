package com.shareforever.intvwdemo.datastructure.stackqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/*
    Queues and Stacks can be used when you need to work with data in a first-in-first-out / last-in-first-out (respectively) order
    and you want to be able discard/remove every item you polled out of the queue / popped out of the stack after processing it.

    Stack:
        (LIFO) data structure
        push and pop
        search
        size
        empty

    Deque:
        can be used as FIFO and LIFO both.
        This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue
        It's not thread-safe ( non-synchronized )
        faster than the synchronized Stack
        Null elements are not accepted
 */
public class StackTest {
    public static void main(String[] args) {
        dequeTest();
        stackTest();
    }

    private static void dequeTest() {
        System.out.println("======== ArrayDeque as a Stack  (LIFO) ========");
        Deque<Integer> stack = new ArrayDeque<>();  //
        stack.push(1);
        stack.push(2);
        stack.push(3);
        ArrayList<Integer> list = new ArrayList<>(stack);
        System.out.println(list); // prints 3, 2, 1  so LIFO As Stack.
        System.out.println(stack.pop());

        System.out.println("======== ArrayDeque as a Queue (FIFO) ========");
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("1st");
        queue.offer("2nd");
        queue.offer("3rd");
        ArrayList<String> list2 = new ArrayList<String>(queue);
        System.out.println(list2); // FIFO
        System.out.println(queue.pop()); // queue.poll()
    }

    /*
        isEmpty
        size()
        search
     */
    private static void stackTest() {
        System.out.println("======== Stack Test ========");
        Stack<String> stackOfCards = new Stack<>();

        // Pushing new items to the Stack
        stackOfCards.push("Jack");
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        stackOfCards.push("Ace");

        System.out.println("Is Stack empty? : " + stackOfCards.isEmpty());
        System.out.println("Size of Stack : " + stackOfCards.size());

        // Search a card
        int position = stackOfCards.search("Queen");
        if (position != -1) {
            System.out.println("Found the element \"Queen\" at position : " + position);
        } else {
            System.out.println("Element not found");
        }

        // Popping items from the Stack
        String cardAtTop = stackOfCards.pop();  // Throws EmptyStackException if the stack is empty
        System.out.println("Stack.pop() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);
        System.out.println();

        // Get the item at the top of the stack without removing it
        cardAtTop = stackOfCards.peek();
        System.out.println("Stack.peek() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);
    }
}
