package com.ReflectionsDemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    通过配置文件读取运行的类 和 方法

 */
public class ReflectionsDemo2 {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties properties = new Properties();
        BufferedReader bufferedReader = new BufferedReader(new
                FileReader("src//main//java//com//ReflectionsDemo//classInfo.txt"));
        properties.load(bufferedReader);
        String className = properties.getProperty("ClassName");
        String classMethod = properties.getProperty("Method");

        Class<?> aClass = Class.forName(className);
        Constructor<?> constructor = aClass.getConstructor(int.class, String.class, String.class);
        Object o = constructor.newInstance(16, "xiaoxi", "beijing");

        Method method = aClass.getMethod(classMethod, String.class);
        Object niubi_invoke = method.invoke(o, "Niubi Invoke");
        System.out.println(niubi_invoke);
    }
}
