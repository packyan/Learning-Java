package com.InterfaceDemo;

public abstract class Coach extends Person {
    public Coach(int age, String name) {
        super(age, name);
    }

    public Coach() {
    }
    public abstract void teach();
}
