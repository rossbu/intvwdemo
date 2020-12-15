package com.shareforever.intvwdemo.corejava.keyword;

import com.shareforever.intvwdemo.pojo.Book;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
    final
    effectively final: A variable which is not declared as final but whose value is never changed after initialization is effectively final.

    The restriction to effectively final variables prohibits access to dynamically-changing local variables, whose capture would likely introduce concurrency problems.
    To lower risk of bugs, they decided to ensure captured variables are never mutated.
 */
public class EffectiveFinal {
    public static void main(String[] args) {
        effectivelyFinalTest();
        finalTest();
    }

    /*
        hint: with final: The compiler would change the code executed in the main method above to:
                    String var1 = "hello world";

              private method is implicitly marked as final.
     */
    private static void finalTest() {
        // w
        final String hello = "hello";
        final String world = "world";
        String test = hello + " " + world;
        System.out.println(test);
    }

    private static void effectivelyFinalTest() {
        // demo
        for (int i = 0; i < 10; i++) {
            int effiectivePrimitive = i;         // effiectivePrimitive is an "effectively final" but NON-final var, yet won't be optimized by compiler
            new Thread(() -> {
                System.out.println("i = " + effiectivePrimitive);
            }).start();
            // effiectivePrimitive++;   If the value of the captured variable changes the compiler gives the same error as the above sample.
            Consumer consumer = (e) -> System.out.println("Value of effectively variable is : " + effiectivePrimitive);
        }

        /*
            demo 1, easy with list type for one element
        */
        String[] effectiveArray = {"yes"};
        Arrays.asList("Cat", "Dog", "Fish").stream().forEach(e -> {
                    effectiveArray[2] = e;
                }
        );
        // effectiveArray = {"No"}; // compiler would know that effectiveArray is re-pointing to sth else.

        /*
            demo2:  AtomicInteger  :  We can use them to atomically modify variables inside lambda expressions:
        */
        AtomicInteger effectivelyFinalAtomicInt = new AtomicInteger(10);
        Supplier functionalInterface = effectivelyFinalAtomicInt::incrementAndGet;
        effectivelyFinalAtomicInt = new AtomicInteger(20);


        /*
            demo3: AtomicReference to wrap the object you want oo mutate in lambda expression.
        */
        final AtomicReference<Book> atomicBook = new AtomicReference<Book>();

        Arrays.asList("Cat", "Dog", "Fish").stream().forEach(e -> {
                    atomicBook.get().setId(1);
                    System.out.println(atomicBook);
                }
        );
    }


}

