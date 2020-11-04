package com.shareforever.intvwdemo.corejava;


/**
 * When synchronizing a non static method, the monitor belongs to the instance.
 * When synchronizing on a static method , the monitor belongs to the class.
 * <p>
 * non-static synchronized method memory is allocated multiple time whenever method is calling.  e.g.:  new Book();
 * static method's memeory is allocated only once at the time of class loading,
 * <p>
 * instance variable blocks
 * class blocks: That means while execution of a static method the whole class is blocked.
 * If one thread is executing a static synchronized method, all other threads trying to execute any static synchronized methods will be blocked.
 */
public class StaticAndInstanceVariable {
    int id = 1;

    public static void main(String args[]) {
        StaticAndInstanceVariable a1 = new StaticAndInstanceVariable();
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        MyThread3 t3 = new MyThread3();
        MyThread4 t4 = new MyThread4();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    /*
       - when 1 thread accesses this method, all other threads are blocked, ( the block ison class level )
       - remove syncrhonized, you wll see the difference in the output
     */
    synchronized static void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
            }
        }
    }

    static void printTableEquivilent(int n) { // equivalent to above method
        synchronized (StaticAndInstanceVariable.class) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                }
            }
        }
    }


    static class MyThread1 extends Thread {
        public void run() {
            StaticAndInstanceVariable.printTable(1);
        }
    }

    static class MyThread2 extends Thread {
        public void run() {
            StaticAndInstanceVariable.printTable(10);
        }
    }

    static class MyThread3 extends Thread {
        public void run() {
            StaticAndInstanceVariable.printTable(100);
        }
    }

    static class MyThread4 extends Thread {
        public void run() {
            StaticAndInstanceVariable.printTable(1000);
        }
    }
}
