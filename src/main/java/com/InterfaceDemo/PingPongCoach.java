package com.InterfaceDemo;

public class PingPongCoach extends Coach implements Skill{
    public PingPongCoach() {
    }

    public PingPongCoach(int age, String name) {
        super(age, name);
    }
    @Override
    public void teach(){
        System.out.println("PingPong Coach teach how to play pingpong");
    }

    @Override
    public void speakEnglish(){
        System.out.println("PingPong Coach can speak Eng");
    }

    @Override
    public void eat(){
        System.out.println("PingPong coach eat pork");
    }
}
