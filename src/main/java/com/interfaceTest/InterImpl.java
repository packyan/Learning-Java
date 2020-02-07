package com.interfaceTest;

public class InterImpl implements Inter{
    @Override
    public void show(){
        System.out.println("this is impl of Inter");
        System.out.println(" " + Inter.age +  " " + Inter.name);
    }
}
