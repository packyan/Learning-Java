package com.InterfaceDemo;

public class PingPongSportMan extends SportMan implements Skill{
    public PingPongSportMan(int age, String name) {
        super(age, name);
    }

    public PingPongSportMan() {
    }

    @Override
    public void speakEnglish() {
        System.out.println("pp player speak Chinese");
    }

    @Override
    public void study() {
        System.out.println("pp player study play pp");
    }

    @Override
    void eat() {
        System.out.println("pp player eat dog");
    }
}
