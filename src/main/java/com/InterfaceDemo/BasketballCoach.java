package com.InterfaceDemo;

public class BasketballCoach extends Coach implements Skill {
    public BasketballCoach(int age, String name) {
        super(age, name);
    }

    public BasketballCoach() {
    }

    @Override
    public void teach(){
        System.out.println("Basketball coach teach how to play like XuKun Cai");
    }

    @Override
    public void speakEnglish(){
        System.out.println("Basketball coach can speaking Chinese");
    }

    @Override
    public  void eat(){
        System.out.println("Basketball coach eat beef");
    }
}
