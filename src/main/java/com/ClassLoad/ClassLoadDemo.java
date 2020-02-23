package com.ClassLoad;

public class ClassLoadDemo {
    public static void main(String[] args) {
        ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(platformClassLoader.getName());

        //app loader
        System.out.println(systemClassLoader.getName());
        // platform loadr
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent.getName());
        // platform loadr's parent  null
        System.out.println(parent.getParent());

    }
}
