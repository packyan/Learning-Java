package com.ReflectionsDemo;

public class Student {
    private int age;
    private String name;
    String address;
    public int grade;

    public Student(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public Student() {

    }

    private Student(int age){
        this.age = age;
    }

    Student(int age, String addr){
        this.age = age;
        this.address = addr;
    }
    private void show(){
        System.out.println(" private show");
    }
    private void show2(){
        System.out.println("pricate show 2");

    }

    public void method(){
        System.out.println("public mthod");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String showAddr(String address){
        System.out.println(address);
        return new StringBuilder(address).reverse().toString();
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", grade=" + grade +
                '}';
    }
}
