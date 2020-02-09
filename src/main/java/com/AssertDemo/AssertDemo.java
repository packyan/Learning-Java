package com.AssertDemo;

public class AssertDemo {
    public static void main(String[] args) {
        int x = -1;
        //java开发很少使用断言，常用的是junit单元测试
        assert  x >0;
        System.out.println(x);
    }
}
