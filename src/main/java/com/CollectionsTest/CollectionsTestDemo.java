package com.CollectionsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsTestDemo {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(124);
        list1.add(123);
        list1.add(213);
        list1.add(12);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);
        Collections.reverse(list1);
        System.out.println(list1);
        Collections.shuffle(list1);
        System.out.println(list1);

        System.out.println("-------------");
        Student stu1 = new Student(12,"mike");
        Student stu2 = new Student(14,"mike2");
        Student stu3 = new Student(11,"mike3");
        Student stu4 = new Student(14,"mike4");

        List<Student> stuList = new ArrayList<>();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);
        System.out.println(stuList);
        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student t1, Student t2) {
                int num = t1.getGrad() - t2.getGrad();
                num = num == 0 ?  t1.getName().compareTo(t2.getName()): num;
                return num;
            }
        });
        System.out.println(stuList);

    }
}
