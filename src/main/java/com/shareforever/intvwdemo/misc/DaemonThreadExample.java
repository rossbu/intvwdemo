package com.shareforever.intvwdemo.misc;


/**
 * main method is non-daemon
 * main method can create daemon thread. t1.setDaemon(true)
 * setDaemon() method can only be called before starting the thread.
 * setDaemon(true|false) : is used for making a USER thread to Daemon thread or vice versa.
 * As you know JVM waits until all non-daemon threads to complete. So it will executes even after the main thread completes.
 */
public class DaemonThreadExample extends Thread {

    public void run() {

        // Checking whether the thread is Daemon or not
        if (Thread.currentThread().isDaemon()) {
            System.out.println("Daemon thread executing");
        } else {
            System.out.println("user(normal) thread executing");
        }
    }

    public static void main(String[] args) {
        /* Creating two threads: by default they are
         * user threads (non-daemon threads)
         */
        DaemonThreadExample t1 = new DaemonThreadExample();
        DaemonThreadExample t2 = new DaemonThreadExample();

        //Making user thread t1 to Daemon
        t1.setDaemon(true);

        //starting both the threads
        t1.start();
        t2.start();
    }
}
