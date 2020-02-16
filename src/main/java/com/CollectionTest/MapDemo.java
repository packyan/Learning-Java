package com.CollectionTest;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {

        Student s = new Student("Xiao Ming", 99);
        Map<String, Student> map = new HashMap<>();
        map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
        Student target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
        System.out.println(target == s); // true，同一个实例
        System.out.println(target.score); // 99
        Student another = map.get("Bob"); // 通过另一个key查找
        System.out.println(another); // 未找到返回null

        map.put("He Liu", new Student("He Liu",94));
        map.put("szxc", new Student("He Liu2",96));
        map.put("xvdsf", new Student("He Liu3",100));
        map.put("asds", new Student("He Liu4",95));
        map.put("cwje", new Student("He Liu9",95));
        map.put("csadw", new Student("He Liu9",95));

        //对key进行排序
        final Set<String> strings = map.keySet();
        List<String> stringList = Arrays.asList(strings.toArray(new String[strings.size()]));
        Collections.sort(stringList);
        System.out.println(stringList);

        //按value排序
        final Set<Map.Entry<String, Student>> entries = map.entrySet();
        List<Map.Entry<String,Student>> listss = new ArrayList<>(entries);
        listss.sort(new Comparator<Map.Entry<String, Student>>() {
            @Override
            public int compare(Map.Entry<String, Student> t1, Map.Entry<String, Student> t2) {
                int i = t1.getValue().score - t2.getValue().score;
                i = i==0? -t1.getValue().name.compareTo(t2.getValue().name):i;
                return -i;
            }
        });

        listss.stream().forEach(System.out::println);
    }
}

class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

