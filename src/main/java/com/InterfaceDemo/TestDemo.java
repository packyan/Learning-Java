package com.InterfaceDemo;

public class TestDemo {
    public static void main(String[] args) {
       PingPongCoach mmm =  new PingPongCoach(60, "Jack");
       PingPongSportMan ccc  = new PingPongSportMan(20,"Ma");
       BasketballCoach bbm = new BasketballCoach(50,"Xukun Cai");
       BasketballSportMan bbp = new BasketballSportMan(21,"Jordan");

        System.out.println(mmm.getName() + ',' + mmm.getAge());
        mmm.eat();
        mmm.speakEnglish();
        mmm.teach();
        System.out.println("---------------");
        System.out.println(bbp.getName() + ',' + bbp.getAge());
        bbp.eat();
        bbp.speakEnglish();
        bbp.study();
    }
}
