package com.SellTicketsMultiThreadDemo;

import java.util.Random;

public class SellThread implements Runnable {
    private  volatile  int  tickets = 50;
    private  Object obj = new Object();
    @Override
    public void run() {
        while(true) {
            /*
                同步代码块的方式进行加锁
             */
            // synchronized (obj), synchronized (this){普通方法的锁},synchronized (Class.class) 静态方法的锁
      /*      synchronized (obj){
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : Selling No." + tickets);
                    tickets--;
                }
                else{
                    System.out.println("All tickets selled");
                    break;
                }
            }*/

      /*
        同步方法加锁
       */
           sell();
        }
    }

    private synchronized boolean sell(){
            if (tickets > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : Selling No." + tickets);
                tickets--;
                return true;
            }
            else {

                System.out.println("All tickets selled");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;
            }
    }
}
