package com.SellTicketsMultiThreadDemo;

public class Producer implements Runnable {
    private DataBox b;

    public Producer(DataBox b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; ++i) {
            b.put(i);
        }
    }
}
