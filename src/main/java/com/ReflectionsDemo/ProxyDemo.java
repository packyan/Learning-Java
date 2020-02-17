package com.ReflectionsDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        final InvocationHandler invocationHandler = new InvocationHandler(){
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println(method);
                System.out.println(method.getName());
                if(method.getName().equals("morning")){
                    System.out.println("good morning "+ objects[0] + " age : " + objects[1]);
                }
                return  null;
            }
        };

        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),//使用的ClassLoader，通常就是接口类的ClassLoader；
                new Class[]{Hello.class}, // 要实现接口的数组
                invocationHandler);

        hello.morning("bobo",12);


    }
}

interface Hello{
    void morning(String name,int age);
}
