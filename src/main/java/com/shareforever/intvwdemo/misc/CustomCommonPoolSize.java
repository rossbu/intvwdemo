package com.shareforever.intvwdemo.misc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static java.lang.StrictMath.sqrt;
import static java.util.stream.Collectors.toList;

    /*
        https://www.javacodemonk.com/java-8-parallel-stream-custom-threadpool-48643a91
    */
public class CustomCommonPoolSize {
    public static void main(String[] args) {
        CustomCommonPoolSize obj = new CustomCommonPoolSize();
//        obj.testParallelOperation();
//        obj.testSequentialOperation();

        // 2nd tricky way to use forkJoinPool to create 4 threads to execute
        obj.forkPoolTask();
    }

    public void testParallelOperation() {
        long start = System.currentTimeMillis();
        IntStream s = IntStream.range(0, 20);
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        s.parallel().forEach(i -> {
            try {
                Thread.sleep(100);
            } catch (Exception ignore) {
            }
            System.out.print((System.currentTimeMillis() - start) + " ms");
        });
        System.out.println("\nOverall time consumed: " + (System.currentTimeMillis() - start) + " ms");
    }

    public void testSequentialOperation() {
        long start = System.currentTimeMillis();
        IntStream s = IntStream.range(0, 20);
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        s.forEach(i -> {
            try {
                Thread.sleep(100);
            } catch (Exception ignore) {
            }
            System.out.print((System.currentTimeMillis() - start) + " ms");
        });
        System.out.println("\nOverall time consumed: " + (System.currentTimeMillis() - start) + " ms");
    }

    private void forkPoolTask(){
        ForkJoinPool forkJoinPool = new ForkJoinPool(16); // Configure the number of threads
        long start = System.currentTimeMillis();
        try {
            forkJoinPool.submit(() -> IntStream.range(1, 10000000)
                    .parallel()
                    .filter(CustomCommonPoolSize::isPrime).boxed()
                    .collect(toList()))
                    .get();
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.print((System.currentTimeMillis() - start) + " ms");
        forkJoinPool.shutdown();

    }

    private static boolean isPrime(long n) {
        return n > 1
                &&
                IntStream.rangeClosed(2, (int) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }
}
