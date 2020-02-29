package com.SellTicketsMultiThreadDemo;

public class ProducerConsumerModelTest {
    public static void main(String[] args) {
        DataBox b = new DataBox();
        Producer p = new Producer(b);
        Consumer c = new Consumer(b);
        Thread thread1 = new Thread(p, "Producer thread");
        Thread thread2 = new Thread(c, "Consumer thread");

        thread1.start();
        thread2.start();
    }

}
