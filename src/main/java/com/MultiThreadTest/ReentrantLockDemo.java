package com.MultiThreadTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        final ReCounter reCounter = new ReCounter();
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    reCounter.add();
                }
            }
        });

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    reCounter.dec();
                }
            }
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(reCounter.getCount());

        final Random random = new Random();
        String[] strings = new String[]{"21312","Asda","123","asd","asd","asd","asd","zxczx","zxczxcas","dasdq"};
        int stringsSize = strings.length;
        final ReTaskQueue taskQueue = new ReTaskQueue();
        final Thread threadsignal = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    int idx = random.nextInt(stringsSize);
                    try {
                        Thread.sleep(random.nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    taskQueue.addTask(strings[idx]);
                }
            }
        });

        final Thread threadawait = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    String str = null;
                    try {
                        str = taskQueue.getTask();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(str);
                }

            }
        });

        threadsignal.start();
        Thread.sleep(20);
        threadawait.start();

    }

}
class ReCounter{
    private int count = 996;
    private  final Lock lock = new ReentrantLock();
    public void add(){
        lock.lock();
        try{
            count++;
        }
        finally {
            lock.unlock();
        }
    }

    public void dec(){
        lock.lock();
        try{
            count--;
        }
        finally {
            lock.unlock();
        }
    }
    public int getCount() {
        return count;
    }
}

class ReTaskQueue{
    Queue<String> queue = new LinkedList<>();
    Lock lock;

    {
        final ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
    }

    Condition condition = lock.newCondition();

    public  void addTask(String s){
        lock.lock();
        try{
            queue.offer(s);
            condition.signalAll();
        }
        finally {
            lock.unlock();
        }

    }

    public  String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.poll();
        }
        finally {
            lock.unlock();
        }

    }
}