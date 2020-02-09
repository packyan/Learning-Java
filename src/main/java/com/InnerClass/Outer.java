package com.InnerClass;

public class Outer {
    public Outer() {
        new Inter(){
            @Override
            public void show() {
                System.out.println("Construct inner class");
            }
        }.show();
    }

    public void method(Inter inter_){
        inter_.show();
    }
}
