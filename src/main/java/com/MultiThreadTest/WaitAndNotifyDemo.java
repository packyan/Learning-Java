package com.MultiThreadTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class WaitAndNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        final Random random = new Random();
        String[] strings = new String[]{"21312","Asda","123","asd","asd","asd","asd","zxczx","zxczxcas","dasdq"};
        int stringsSize = strings.length;
        final TaskQueue taskQueue = new TaskQueue();
        final Thread thread = new Thread(new Runnable() {
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

        final Thread thread1 = new Thread(new Runnable() {
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

        thread.start();
        Thread.sleep(20);
        thread1.start();
    }
}
class TaskQueue{
    Queue<String> queue = new LinkedList<>();
    public synchronized void addTask(String s){
        queue.offer(s);
        this.notify();
    }

    public synchronized String getTask() throws InterruptedException {
        //会卡住， 当其获得锁，又判断为空，则add无法获得锁。
        while(queue.isEmpty()){
            this.wait();
            //释放锁，同时等待
        }
        return queue.poll();
    }
}
