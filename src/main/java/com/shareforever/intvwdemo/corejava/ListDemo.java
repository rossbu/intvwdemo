package com.shareforever.intvwdemo.corejava;

import java.util.*;

class ListDemo {
    /**
     * FIFO.
     *
     * @param args
     */
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add(0, "3");
        list.add(1, "4");
//        list.forEach(System.out::println);


    }
}
