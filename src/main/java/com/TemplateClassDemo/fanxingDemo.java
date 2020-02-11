package com.TemplateClassDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fanxingDemo {
    public static void main(String[] args) {
        List<Person> listP = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listP.add(new Person(String.valueOf(i)));
        }
        Collections.sort(listP);
        listP.stream().map(person -> person.getName()).forEach((person)->{
            System.out.print(person);
            System.out.print(" ");
        });
    }
}

class Person implements Comparable<Person>{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }
}
