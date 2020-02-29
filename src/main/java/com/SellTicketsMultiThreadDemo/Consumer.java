package com.SellTicketsMultiThreadDemo;



public class Consumer implements  Runnable {
    private DataBox b;

    public Consumer(DataBox b) {
        this.b = b;
    }

    @Override
    public void run() {
        while(true){
           b.get();
        }
    }
}
