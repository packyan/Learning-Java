package com.MapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapTestDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("jack",100);
        map.put("ma", 99);
        map.put("me",120);
        map.put("ae",123);
        map.put("bw",89);
        for(var key : map.keySet()){
            System.out.println(key + "," + map.get(key));
        }
        for(var value : map.values()){
            System.out.println(value);
        }
        for(var mapKVset : map.entrySet()){
            System.out.println(mapKVset.getKey() + ", " + mapKVset.getValue());
        }

        System.out.println("Input a string");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Map<Character, Integer> mapCounter = new HashMap<>();
        for(Character ch : str.toCharArray()){
            if(! mapCounter.containsKey(ch))
                mapCounter.put(ch,1);
            else
                mapCounter.put(ch, mapCounter.get(ch) + 1);
        }
        //System.out.println(mapCounter);
        StringBuilder strb = new StringBuilder();
        for(var key : mapCounter.keySet()){
            strb.append(key).append(" : ").append(mapCounter.get(key)).append(" ");
        }
        System.out.println(strb);
            /*
            TreeMap 对键进行排序
             */
        Map<String, Integer> treemap = new TreeMap<>(map);
        //如果类没有实现COmparable 方法，需要写一个比较器
        for(var key : treemap.keySet()){
            System.out.println(key + " " + treemap.get(key));
        }
    }
}
