package com.inherit;

public class SmartPhone extends Phone {
    @Override
    public  void call(String name){
        System.out.println("open camera...\n");
        System.out.println("call to " + name);
    }
}
