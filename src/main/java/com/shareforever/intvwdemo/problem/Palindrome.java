package com.shareforever.intvwdemo.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    Stack stack = new Stack();
    Queue queue = new LinkedList();

    /*
        pushes a character onto a stack.
     */
    void pushCharacter(char ch) {
        stack.push(ch);
    }

    /*
        enqueues a character in the  instance variable.
    */
    void enqueueCharacter(char ch) {
        queue.add(ch);
    }

    /*
        pops and returns the character at the top of the  instance variable.
    */
    char popCharacter() {
        return (char) stack.pop();
    }

    /*
        dequeues and returns the first character in the  instance variable.
    */
    char dequeueCharacter() {
        return (char) queue.poll();
    }

    public static void main(String[] args) {
        String input = "cabbac";
        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Palindrome p = new Palindrome();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println("The word, " + input + ", is "
                + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
    }
}
