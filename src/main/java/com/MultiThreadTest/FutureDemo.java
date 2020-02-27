package com.MultiThreadTest;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        final Future<Integer> submit = executorService.submit(new longtimeCompute());

        System.out.println("getting res");
        Integer res = submit.get();
        System.out.println("got res");

        System.out.println(res);
    }
}

class longtimeCompute implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 100;
    }
}