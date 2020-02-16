package com.CollectionTest;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        /*
            hashset就是对hashmap的一个简单封装，没有了value而已。
         */
        Random random = new Random();
        Set<String> treeSet = new TreeSet<>();
        for (int i = 0; i < 20; i++) {
            treeSet.add(String.valueOf(random.nextInt(30)));
        }
        for (var str :
                treeSet) {
            System.out.println(str);
        }
    }
}
