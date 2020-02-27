package com.MultiThreadTest;

import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
         executorService.submit(new task(""+ i));
        }
        //放入线程池自动执行
        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        //我们可以提交一次性任务，它会在指定延迟后只执行一次：
        scheduledExecutorService.schedule(new task("scheduled task..." ), 5, TimeUnit.SECONDS);

        //按一定之间固定触发,// 2秒后开始执行定时任务，每3秒执行:
        //如果超过3秒，任务依然没有完成，会延迟开始，不会并发
        //如果任务的任何执行遇到异常，则将禁止后续任务的执行。
        scheduledExecutorService.scheduleAtFixedRate(new task("fixed reate 2s"),0,3,TimeUnit.SECONDS);

        // 2秒后开始执行定时任务，以4秒为间隔执行:
        scheduledExecutorService.scheduleWithFixedDelay(new task("fixed delay 4s"),0,4,TimeUnit.SECONDS);


        Thread.sleep(20*1000);
        scheduledExecutorService.shutdown();

    }
}
class task implements Runnable{
    private  String name;

    public task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end : " + name);
    }
}
