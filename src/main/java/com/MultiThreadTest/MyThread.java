package com.MultiThreadTest;

import java.util.Objects;
import java.util.Random;

public class MyThread extends Thread {

    //被线程执行地代码，通过start调用 run方法
    public Random random = new Random(1);
    String name;
    int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyThread myThread = (MyThread) o;
        return id == myThread.id &&
                Objects.equals(random, myThread.random) &&
                Objects.equals(name, myThread.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(random, name, id);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i <999; i ++) {
            System.out.println(this.getName() + " " + i);
            /*try {
                Thread.sleep(random.nextInt(20));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }




}
