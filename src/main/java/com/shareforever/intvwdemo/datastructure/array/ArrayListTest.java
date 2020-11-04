package com.shareforever.intvwdemo.datastructure.array;

import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {
        // if you just simply add element and sout the list from 0 - end, it would like like 'FIFO'
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5); // index == 0
        list.add(4); // index == 1
        list.add(3); // index == 2
        list.add(2); // index == 3
        list.add(1); // index == 4
        System.out.println(list);

        // But you can use INDEX, you can change the order of elements. while Deque won't let you, Queue is guarranted FIFO
        list.set(4, 5);
        list.set(3, 4);
        list.set(2, 3);
        list.set(1, 2);
        list.set(0, 1);
        System.out.println(list);

        // be alert if you remove any in the loop, then it's a tricky behaviour
        for (int i = 0; i < list.size(); i++) {
            list.remove(Integer.valueOf(i)); // NEVER DO REMOVE In array list this.
        }
        System.out.println(list);
        // you remove 3 elements, the size will be 2
//        list.remove(4);System.out.println(list);
//        list.remove(0);System.out.println(list);
//        list.remove(1);System.out.println(list);
//
//        // use lambda remove again
//        list.removeIf(e->e==2);
//        System.out.println(list);
    }
}
