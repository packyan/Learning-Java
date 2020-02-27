package com.MultiThreadTest;

public class SynchronizedMethod {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(new Stu());
        final Thread thread1 = new Thread(new Teach());
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        //没有加锁， 结果可能不是0，每次运行几乎都不一样
        //在对count修改处加入锁，可以保证每一次执行只有一个线程操作，结果必定是0
        System.out.println("Counter : " + Counter.count);

        //除了对语句加锁，也可以对一个方法进行加锁。设计一个线程安全的counter
        ThreadSafeCounter threadSafeCounter1 = new ThreadSafeCounter();
        ThreadSafeCounter threadSafeCounter2 = new ThreadSafeCounter();
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    threadSafeCounter1.add();
                }
            }
        });

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    threadSafeCounter1.dec();
                }
            }
        });


        final Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    threadSafeCounter2.add();
                }
            }
        });

        final Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    threadSafeCounter2.dec();
                }
            }
        });

        thread3.start();
        thread4.start();
        thread5.start();
        thread2.start();

        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println(threadSafeCounter1.get());
        System.out.println(threadSafeCounter2.get());


    }


}

class Counter {
    public static int count = 0;
    public final static Object lock = new Object();
}

class Stu implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count++;
            }
        }
    }
}

class Teach implements Runnable {
    @Override

    public void run() {

        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count--;
            }
        }
    }
}

class ThreadSafeCounter {
    private int count = 0;

    public void add() {
        synchronized (this) {
            count++;
        }
    }

    public void dec() {
        synchronized (this) {
            count--;
        }
    }

    public int get() {
        return count;
    }
}