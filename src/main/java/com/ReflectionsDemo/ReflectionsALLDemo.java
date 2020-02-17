package com.ReflectionsDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionsALLDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        /*
            获取Class的方法
         */
        Student stu = new Student();
        Class stu1 = Class.forName("com.ReflectionsDemo.Student"); //从名字获得
        Class stu2 = com.ReflectionsDemo.Student.class; // 从类名.class 获得
        Class stu3 = stu.getClass(); // 从实例对象获得
        System.out.println(stu1.getName());
        System.out.println(stu1 == stu2 && stu2 == stu3);

        /*
            获取构造方法
            通过Class实例获取Constructor的方法如下：
            getConstructor(Class...)：获取某个public的Constructor；
            getDeclaredConstructor(Class...)：获取某个Constructor；
            getConstructors()：获取所有public的Constructor；
            getDeclaredConstructors()：获取所有Constructor。
         */
        final Constructor constructor = stu1.getConstructor();
        final Constructor declaredConstructor = stu1.getDeclaredConstructor(); // 可以指定参数
        System.out.println("-------获取构造方法 constructor 与  declaredConstructor------------");
        System.out.println(constructor);
        System.out.println(declaredConstructor);
        final Constructor[] constructors = stu1.getConstructors();
        final Constructor[] declaredConstructors = stu1.getDeclaredConstructors();
        System.out.println("-------constructors 与  declaredConstructors------------");
        System.out.println("----constructos public: ");
        for(var con : constructors){
            System.out.println(con);
        }
        System.out.println("----declaredConstructors all:");
        for (var con :
                declaredConstructors) {
            System.out.println(con);
        }

        final Constructor declaredConstructor1 = stu1.getDeclaredConstructor(int.class);
        //直接访问报错
        //set acc
        declaredConstructor1.setAccessible(true);
        final Object o = declaredConstructor1.newInstance(19);
        System.out.println(o);

        final Constructor constructor1 = stu1.getConstructor(int.class, String.class, String.class);
        final Object o1 = constructor1.newInstance(32, "ppd", "beijing");
        System.out.println(o1);

        System.out.println("-------------获取方法 getDeclaredMethods------------");
        final Method[] declaredMethods = stu1.getDeclaredMethods();
        for (var method:
             declaredMethods) {
            System.out.println(method);
        }

        final Method showAddr = stu1.getMethod("showAddr", String.class);
        showAddr.invoke(o1,"invoke niubi addr");

        final Method show2 = stu1.getDeclaredMethod("show2");
        show2.setAccessible(true);
        show2.invoke(o1);


        System.out.println("------------获取成员 getField ");
        final Field field = stu1.getField("grade");
        final Object o2 = field.get(o1);

        System.out.println("public field get  "+ field.getName() + " " + o2);
        final Field address = stu1.getDeclaredField("address");
        address.setAccessible(true);
        final Object o3 = address.get(o1);
        System.out.println("private field get " + address.getName() + " " + o3);

        System.out.println("------------获取 继承关系");
        final Class superclass = stu1.getSuperclass();
        System.out.println(stu1);
        System.out.println(superclass);
        System.out.println(superclass.getSuperclass());

        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        Class osuper = n.getSuperclass();
        System.out.println(osuper);
        System.out.println(osuper.getSuperclass());

        System.out.println("--------获取接口");
        final Class[] interfaces = i.getInterfaces();
        for (var inter :
                interfaces) {
            System.out.println(inter);
        }
        for (var inter :
                Thread.class.getInterfaces()) {
            System.out.println(inter);
        }


    }
}
