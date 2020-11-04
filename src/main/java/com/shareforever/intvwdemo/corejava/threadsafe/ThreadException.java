package com.shareforever.intvwdemo.corejava.threadsafe;

public class ThreadException {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.setDaemon(true);
        thread.start();
        thread.stop();

        Runnable runnalbe = new Runnable() {
            @Override
            public void run() {

            }
        };
    }
}
