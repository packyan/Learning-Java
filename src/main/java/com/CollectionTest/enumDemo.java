package com.CollectionTest;

import java.util.Arrays;

public class enumDemo {
    public static void main(String[] args) {
        System.out.println(SizeENUM.MEDIUM == SizeENUM.MEDIUM);
        System.out.println(SizeENUM.LARGE + " " + SizeENUM.LARGE.getName());
        System.out.println(Arrays.toString(SizeENUM.values()));
        System.out.println(SizeENUM.valueOf("MEDIUM"));
    }
}
enum SizeENUM{
    SMALL("S"),MEDIUM("M"),LARGE("L");
    private String name;

    SizeENUM(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
