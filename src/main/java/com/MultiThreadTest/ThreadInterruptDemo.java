package com.MultiThreadTest;

import javax.print.attribute.standard.RequestingUserName;

public class ThreadInterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread mythread = new Thread(new myRunnable());

        System.out.println("thread start...");
        mythread.start();
        Thread.sleep(5);
        mythread.interrupt();
        System.out.println("main interruput my thread");
        mythread.join();
        System.out.println("main return");


        Thread mythread2 = new Thread(new myVolatileRunnable());
        mythread2.start();
        Thread.sleep(5);
        myVolatileRunnable.running = false;
        mythread2.join();
        System.out.println("my thread 2 end");

        Thread mythread3 = new Thread(new DaemonThread());
        //without daemon threading will not stop
        mythread3.setDaemon(true);
        mythread3.start();
        Thread.sleep(10);

        System.out.println("main end");


    }

}
class DaemonThread implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("daemoning...");
        }
    }
}
class myRunnable implements Runnable{
    @Override
    public void run() {
        //for (int i = 0; i < 30 && !Thread.currentThread().isInterrupted(); ++i)
        int i = 0;
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("processing : " + ++i);

        }
    }
}

class myVolatileRunnable implements  Runnable{
    public static volatile boolean running = true;
    @Override
    public void run() {
        int i = 0;
        while(running){
            System.out.println("running " + ++i);
        }
    }
}
