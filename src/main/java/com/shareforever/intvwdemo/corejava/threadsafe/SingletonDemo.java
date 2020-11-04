package com.shareforever.intvwdemo.corejava.threadsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonDemo {
    public static void main(String[] args) {
        SingletonByEnum.INSTANCE.handleLogic();
    }

    /**
     * Eager instance creation & Thread safe
     */
    static class StaticNewSingleTon {
        private StaticNewSingleTon() {
        }

        ;
        private static StaticNewSingleTon instance = new StaticNewSingleTon();

        public static StaticNewSingleTon getInstance() {
            return instance;
        }
    }

    /**
     * Lazy instantiation - Singleton Holder Pattern
     * static class to get instance of the class
     */
    static class StaticClassNewSingleton {
        private StaticClassNewSingleton() {
        }

        private static class InstanceHolder {
            public static StaticClassNewSingleton instance = new StaticClassNewSingleton();
        }

        public static StaticClassNewSingleton getInstance() {
            return InstanceHolder.instance;
        }
    }


    /**
     * old lazy syncrhozed(*.class) way. NOT this.
     * urgly double instance check
     */
    static class SingletonBySynchronized {
        private SingletonBySynchronized() {
        }

        ;
        private static SingletonBySynchronized instance;

        public static SingletonBySynchronized getInstance() {
            if (null == instance) {
                // this or instance var can't be used in static context
                synchronized (SingletonBySynchronized.class) {
                    if (null == instance)
                        instance = new SingletonBySynchronized();
                }
            }
            return instance;
        }
    }


    /**
     * use the Local reentrantlock similar to synchronized block
     * here is a trick: use only try - finally without catch
     */
    static class SingletonByLock {
        private SingletonByLock() {
        }

        private static SingletonByLock instance;
        private static Lock lock = new ReentrantLock();

        public static SingletonByLock getInstance() {
            if (instance == null) {
                lock.lock();
                try {
                    instance = new SingletonByLock();
                } finally {
                    lock.unlock();
                }
            }

            return instance;
        }
    }

    enum SingletonByEnum {
        INSTANCE;

        void handleLogic() {
            System.out.println("do sth like read file or writing to a file");
        }

        public static SingletonByEnum getInstance() {
            return INSTANCE;
        }
    }


}


