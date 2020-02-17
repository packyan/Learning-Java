package com.ReflectionsDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionsTestDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class stu = new Student().getClass();
        System.out.println(stu);
        Class stu2 = Student.class;
        System.out.println(stu2);
        //Class stu3 = Class.forName("Student"); //ClassNotFoundException
        /*
                forName 要完整名称
         */
        Class stu3 = Class.forName("com.ReflectionsDemo.Student");
        System.out.println(stu3);

        System.out.println(stu == stu2 && stu2 == stu3);

        /*
            反射获取构造方法，并使用
         */
        //1 获取class对象
        Class stu_class = Student.class;

        // 返回构造对象的数组，所有**公共的构方法**，但是私有和默认的拿不到。

        Constructor[] constructors = stu_class.getConstructors();
        for(Constructor con : constructors){
            System.out.println(con);
        }

        System.out.println("-------------------");
        /*/
            getDeclaredConstructors 获取所有构造方法
         */
        Constructor[] declaredConstructors = stu_class.getDeclaredConstructors();
        for (var con :
                declaredConstructors) {
            System.out.println(con);

        }

        System.out.println("-------------------");
        /*
            获取单个构造函数,单个构造方法，
            参数： 获取的构造方法的参数个数， 和 数据类型的字节码文件对象， 即 Class.class;
         */
        Constructor constructor = stu_class.getConstructor();
        System.out.println(constructor);
        Student stu_CON =(Student) constructor.newInstance();
        System.out.println(stu_CON);

        Constructor constructor_params = stu_class.getConstructor(int.class,String.class, String.class);
        Student stu_params = (Student) constructor_params.newInstance(12,"23","sad");
        System.out.println(stu_params);

        System.out.println("-------------------");
        /*
            getDeclaredConstructors 全部构造方法，都可以拿到。
         */
        Constructor constructor1 = stu_class.getDeclaredConstructor();
        System.out.println(constructor1);

        //访问默认构造方法
        Constructor declaredConstructor = stu_class.getDeclaredConstructor(int.class, String.class);
        Student stu_delCon = (Student) declaredConstructor.newInstance(12,"lin");
        System.out.println(stu_delCon);

        //jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        //访问 私有构造方法，报错.
        /*
               setAccessible = true 取消访问检查，暴力反射
         */
        Constructor PrivatedeclaredConstructor = stu_class.getDeclaredConstructor(int.class);
        PrivatedeclaredConstructor.setAccessible(true);
        Student stu_delCon_private = (Student) PrivatedeclaredConstructor.newInstance(12);
        System.out.println(stu_delCon_private);


        System.out.println("--------------反射获取成员变量");
        Field[] field = stu_class.getFields();
        Field[] declaredFields = stu_class.getDeclaredFields();
        System.out.println("-------public fields");
        for (var fi:
             field) {
            System.out.println(fi);
        }
        System.out.println("-------declared fields");
        for (var dfi :
                declaredFields) {
            System.out.println(dfi);
        }

        System.out.println("--------------反射获取成员变量,赋值");
        //私有的不能赋值
        Field address = stu_class.getField("grade");
        Constructor constructor2 = stu_class.getConstructor();
        //Student stu_1 = (Student) constructor2.newInstance();
        Object stu_1 = constructor2.newInstance();
        address.set(stu_1, 11);
        System.out.println(stu_1);

        System.out.println("反射获取方法");
        Method showAddr = stu_class.getMethod("showAddr", String.class);
        Constructor constructor3 = stu_class.getConstructor(int.class, String.class, String.class);
        Object stu_3 = constructor3.newInstance(13,"hhao","lle");
        Object s = showAddr.invoke(stu_3,"my home is nj");
        System.out.println(s);

        System.out.println("-----反射跳过泛型检查");
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(29);
        list.stream().forEach(System.out::println);

        Class listClass = list.getClass();
        Method add = listClass.getMethod("add", Object.class);
        add.invoke(list,"asd");
        add.invoke(list,"xxx");
        System.out.println(list);


    }
}
