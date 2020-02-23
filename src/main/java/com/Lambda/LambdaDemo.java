package com.Lambda;

public class LambdaDemo {
    public static void main(String[] args) {

//        /*
//            CLASS METHOD
//         */
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread1 = new Thread(myRunnable,"my runnable");
//        thread1.start();
//
//        /*
//         inner class method
//         */
//       new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("匿名内部类");
//            }
//        }, " my runnable -2").start();
//
//       /*
//        Lambda
//        */
//
//       new Thread(() -> {
//           System.out.println("Lambda thread");
//       }).start();


       /*
            通过类 实现接口，再调用类方法实现
        */
        EatableImpl myEat = new EatableImpl();
        useEat(myEat);

        /*
            匿名内部类
         */
        useEat(new Eatable() {
            @Override
            public void eat() {
                System.out.println("匿名内部类 eatting all of things");
            }
        });


        /*
            lambda 表达式方法
         */
        useEat(()->{
            System.out.println("Lambda 表达式 eatting all of things");
        });


        useFly((String s)->{
            System.out.println(s);
            System.out.println("Lambda Flying");
        });


    }

    public static void useEat(Eatable e){
        e.eat();
    }

    public static void useFly(Flayable f){
        f.fly("飞机");
    }


}
