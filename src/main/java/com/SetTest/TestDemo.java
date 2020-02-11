package com.SetTest;

import java.util.*;

public class TestDemo {
    public static void main(String[] args) {

        /*
            不重写hashcode方法，默认情况下不同对象，hash值不同，
            可以通过重写，让内容相同的对象，拥有相同的hash值/

         */
        Student stu1 = new Student(12, "林绮");
        Student stu2 = new Student(12,"林绮2" );
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());

        Set<Student> stuSet = new HashSet<>();
        Student stu3 = new Student(17,"lin林lin" );
        Student stu4 = new Student(13,"li绮" );
        Student stu5 = new Student(13,"li绮" );


        stuSet.add(stu1);
        stuSet.add(stu2);
        stuSet.add(stu3);
        stuSet.add(stu4);
        stuSet.add(stu5);
        for(Student stu : stuSet){
            System.out.println(stu.getName() + " " + stu.getAge());
        }
        System.out.println("-----------------------------\n");
        /*
            LinkedHashSet 可以保障顺序
         */
        Set<Student> stuLinkedSet = new LinkedHashSet<>();
        stuLinkedSet.add(stu1);
        stuLinkedSet.add(stu2);
        stuLinkedSet.add(stu3);
        stuLinkedSet.add(stu4);
        stuLinkedSet.add(stu5);
        for(Student stu : stuLinkedSet){
            System.out.println(stu.getName() + " " + stu.getAge());
        }

        /*
            TreeSet 指定排序顺序的set， 无参构造为自然排序，有参数可以指定排序方法
         */
        System.out.println("-----------------------------\n");
        Set<Student> studentTreeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                // 0 不存储，认为一样， 1 -1 为升序降序存储
                int num = student.getAge() - t1.getAge();
                // 年龄一样，要比较姓名了。
                num = num == 0 ?  student.getName().compareTo(t1.getName()) : num;
                return num ;
            }
        });
        studentTreeSet.add(stu1);
        studentTreeSet.add(stu2);
        studentTreeSet.add(stu3);
        studentTreeSet.add(stu4);
        studentTreeSet.add(stu5);
        for(var stu : studentTreeSet){
            System.out.println(stu.getName() + ", " + stu.getAge());
        }
    }
}
