package com.SellTicketsMultiThreadDemo;

public class DataBox {
    private int milk;
    private  boolean state = false;
    public synchronized void put(int milk){
        // 生产完毕，等待读取
        if(state == true){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            this.milk = milk;
            System.out.println("生产 " + this.milk +" 牛奶");
            state = true;
            this.notifyAll();

    }

    public synchronized  void get(){
        if(state == false){
            //没有牛奶，等待生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


            System.out.println("取出 " + this.milk + " 牛奶");
            state = false;
            this.notifyAll();

    }
}
