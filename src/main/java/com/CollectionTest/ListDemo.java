package com.CollectionTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListDemo {
    public static void main(String[] args) {
        System.out.println("-----List常用接口");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        list.add(4,String.valueOf(66));
        //删除指定索引的元素：int remove(int index)
        list.remove(9);
        list.remove("1");
        list.get(2);
        list.size();
        for(Iterator it = list.iterator(); it.hasNext();){
            System.out.print(it.next());
            System.out.print(" ");
        }
        System.out.println();

        System.out.println("------List to array");
        String[] strs = list.toArray(new String[list.size()]);
        for(String str : strs){
            System.out.print(str);
            System.out.print(" ");
        }
        System.out.println();

        System.out.println("---------euqals 方法");
        final Person person = new Person("bob");
        final Person person1 = new Person("bob");
        final Person lucy = new Person("lucy");
        List<Person> listp = new ArrayList<>();
        listp.add(person);
        listp.add(lucy);
        System.out.println(listp.contains(new Person("lucy")));
        System.out.println(person.equals(person1));


    }
}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
