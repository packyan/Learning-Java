package com.GenericTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("string");
        c.add(1);
        Iterator iterator = c.iterator();
        for( var str : c){
            System.out.println(str);
        }
        System.out.println("--------");

        Generic<String> stringGeneric = new Generic<>();
        stringGeneric.setName("asd");
        System.out.println(stringGeneric.getName());
        Generic<Integer> integerGeneric = new Generic<>();
        integerGeneric.setName(1233);
        System.out.println(integerGeneric.getName());
        stringGeneric.show("12344");
        integerGeneric.show(100);

        System.out.println(" 泛型方法");
        stringGeneric.genericShow(123);
        stringGeneric.genericShow2(3123);
        integerGeneric.genericShow("3123");
        integerGeneric.genericShow2(12321);

        System.out.println("--------------\n");
        GenericInterImpl<String> gti = new GenericInterImpl<>();
        gti.showGenericImpl("3123124");

        System.out.println("---------------");
        System.out.println(sum(10,10,20,30));
        System.out.println(sum(123,124,14,123));
    }

    /*
        可变参数要放到最后。
     */
    public static int  sum (int b, int... a){
        /*
            a 是一个数组
         */
        int sum = 0;
        for(int a_i : a){
            sum += a_i;
        }
        return sum;
    }
}
