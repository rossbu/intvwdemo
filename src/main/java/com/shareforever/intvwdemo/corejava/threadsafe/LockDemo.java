package com.shareforever.intvwdemo.corejava.threadsafe;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;

import static java.lang.Thread.sleep;

/**
 * https://www.tutorialspoint.com/java_concurrency/concurrency_lock.htm
 * Guarantee of sequence − Synchronized block does not provide any guarantee of sequence in which waiting thread will be given access. Lock interface handles it.
 * <p>
 * No timeout − Synchronized block has no option of timeout if lock is not granted. Lock interface provides such option.
 * <p>
 * Single method − Synchronized block must be fully contained within a single method whereas a lock interface's methods lock() and unlock() can be called in different methods.
 * <p>
 * ReentrantLock is used with try/finally
 * <p>
 * https://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
 */
public class LockDemo implements Runnable {
    // This method is thread-safe just like the synchronized counterpart
    final ReentrantLock lock = new ReentrantLock();
    int count = 0;

    public static void main(String[] args) {
//        doTest();
//        stampedLockTest();
        stampedOptimisticRead();

    }

    private static void stampedOptimisticRead() {
        StampedLock lock = new StampedLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println(Thread.currentThread().getName() + " Write Lock acquired");
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(stamp);
                System.out.println(Thread.currentThread().getName() + " Write done - unlocked");
            }
        });

        executor.submit(() -> {
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println(Thread.currentThread().getName() + " Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(1);
                System.out.println(Thread.currentThread().getName() + " Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(2);
                System.out.println(Thread.currentThread().getName() + " Optimistic Lock Valid: " + lock.validate(stamp));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(stamp);
            }
        });


        executor.shutdown();
    }

    private static void stampedLockTest() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        final StampedLock lock = new StampedLock(); // java8 new lock

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                sleep(1);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }
        });

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("foo"));
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        executor.shutdown();
    }


    private static void doTest() {
        final int threadCount = 5;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        final LockDemo task = new LockDemo();
        for (int i = 0; i < threadCount; i++) {
            service.execute(task);
        }
        service.shutdown();
    }

    @Override
    public void run() {
        // This method is thread-safe just like the synchronized counterpart
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
            System.out.println("Processing...");
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + ": Lock released.");
            lock.unlock();
        }
    }
}
