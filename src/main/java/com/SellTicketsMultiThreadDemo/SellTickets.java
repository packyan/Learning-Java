package com.SellTicketsMultiThreadDemo;

public class SellTickets {
    public static void main(String[] args) {
        SellThread sellThread = new SellThread();
        Thread sellThread1 = new Thread(sellThread, "窗口1");
        Thread sellThread2 = new Thread(sellThread, "窗口2");
        Thread sellThread3 = new Thread(sellThread, "窗口3");

        sellThread1.start();
        sellThread2.start();
        sellThread3.start();
    }
}
