package com.inherit;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        Phone ph =  new Phone();
        SmartPhone sph = new SmartPhone();
        ph.call("Jack Ma");
        sph.call("me");
    }
}
