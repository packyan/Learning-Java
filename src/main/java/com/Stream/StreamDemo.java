package com.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> mylist = new ArrayList<>();
        mylist.add("zjh");
        mylist.add("zkl");
        mylist.add("zs");
        mylist.add("sdd");
        mylist.add("sdf");
        mylist.add("vsd");
        mylist.stream().filter(s -> s.startsWith("z")).filter(s-> s.length() > 2).forEach(
                s -> System.out.println(s)
        );

       List my3list =  mylist.stream().filter((s -> s.length()>2)).collect(Collectors.toList());
       my3list.stream().forEach(System.out::println);

        System.out.println("--------------");
       Map<String, String> map = mylist.stream().filter((s -> s.startsWith("z"))).collect(
               Collectors.toMap((s -> s.substring(0,2)),(s->s)));
       Set<String> keys = map.keySet();
       for(var key : keys){
           System.out.println(key + " : " + map.get(key));
       }



    }
}
