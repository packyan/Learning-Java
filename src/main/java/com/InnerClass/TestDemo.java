package com.InnerClass;

public class TestDemo {
    public static void main(String[] args) {
        Outer newouter = new Outer();
        newouter.method(new Inter() {
            @Override
            public void show() {
                System.out.println("call inner class by a method");
            }
        });
    }
}
