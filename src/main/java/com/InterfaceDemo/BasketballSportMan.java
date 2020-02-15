package com.InterfaceDemo;

public class BasketballSportMan extends SportMan implements Skill{
    public BasketballSportMan(int age, String name) {
        super(age, name);
    }

    public BasketballSportMan() {
    }

    @Override
    public void speakEnglish() {
        System.out.println("B player can speak english too");
    }

    @Override
    public void study() {
        System.out.println("B player study Xukun cai");
    }

    @Override
    void eat() {
        System.out.println("B player eat shit");
    }
}
