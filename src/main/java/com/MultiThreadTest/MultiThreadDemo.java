package com.MultiThreadTest;

public class MultiThreadDemo {
    public static void main(String[] args) {
        /*MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        //run方法没有启动线程，只是普通方法，
      *//*  myThread1.run();
        myThread2.run();*//*
        // start方法，启动多线程，调用run
        myThread1.start();
        myThread2.start();*/

        //继承thread类的方式来实现多线程
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        System.out.println(myThread1.getPriority());
        System.out.println("Thread priority Max and Min"+ Thread.MAX_PRIORITY
        +" " + Thread.MIN_PRIORITY);
        // priority 1-10
        myThread1.setPriority(10);
        myThread2.setPriority(5);
        myThread3.setPriority(1);
        System.out.println("Thread 1 priority : " + myThread1.getPriority());
        System.out.println("Thread 2 priority : " + myThread1.getPriority());
        System.out.println("Thread 3 priority : " + myThread1.getPriority());

        myThread1.setName("Airplane");
        myThread2.setName("CRH");
        myThread3.setName("Car");
/*
        myThread1.start();
        myThread2.start();
        myThread3.start();*/

        /*
            通过 创建 一个实现 runable的类
            覆写run方法
         */

        Thread thread1 = new Thread(new MultiThreadRunnable(),"Runnable Thread");
        thread1.start();
        thread1.start();
        thread1.start();
    }
}
