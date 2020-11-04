package com.shareforever.intvwdemo.corejava.keyword;

public class RuntimeTest {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(maxMemory);
    }
}

