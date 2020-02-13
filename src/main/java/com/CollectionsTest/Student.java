package com.CollectionsTest;

public class Student {
    private  int grad;
    private  String name;

    public Student(int grad, String name) {
        this.grad = grad;
        this.name = name;
    }

    public Student() {

    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grad=" + grad +
                ", name='" + name + '\'' +
                '}';
    }
}
