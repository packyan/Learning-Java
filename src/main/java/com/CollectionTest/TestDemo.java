package com.CollectionTest;

import java.util.*;
//集合 对象的接口


/*
ALt+7 查看class结构
 */
public class TestDemo {
    public static void main(String[] args) {
        /*
            集合的一般api
         */
        //collection 对象
        System.out.println("集合API测试");
        Collection<String> collectionsStr = new ArrayList<>();
        //添加元素
        collectionsStr.add("Java");
        collectionsStr.add("good");
        // ArrayList add 永远返回 true，不检查重复
        System.out.println(collectionsStr.add("e"));

        //remove方法，返回true或false 看原集合存在不存在元素
        System.out.println(collectionsStr.remove("e"));
        System.out.println(collectionsStr.remove("123"));
        // toString 方法被override， 可以显示正常输出。
        System.out.println(collectionsStr);



        System.out.println(collectionsStr.contains("good"));
        System.out.println(collectionsStr.contains("Javae"));

        System.out.println(collectionsStr.isEmpty());

        collectionsStr.clear();
        System.out.println(collectionsStr);
        System.out.println(collectionsStr.isEmpty());

        System.out.println("----------------------------");

        System.out.println("集合遍历测试");
        List<String> c = new ArrayList<>();
        c.add("123");
        c.add("asdf");
        c.add("java");
        Iterator<String> itr = c.iterator();
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.next());

        //到了null会报错
        Iterator<String> itr2 = c.iterator();

        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }

        System.out.println("并发修改异常");
        Iterator<String> itr3 = c.iterator();
        try{
            while(itr3.hasNext()){
                String s = itr3.next();
                if(s == "java")
                    c.add("jaee");
            }
        }
        catch (ConcurrentModificationException e)
        {
            e.printStackTrace();
        }

        /*
            在迭代中修改迭代的集合，非常不推荐！！！
            get方法不会对  modCount 实际修改集合的次数。
                        expectedModCount 预期修改集合的次数。
                        进行一致性判断。
         */
        for(int i = 0; i< c.size(); ++i){
            String s = c.get(i);
            if(s == "java")
                c.add("jaee");
        }
        System.out.println(c);

        /*
            列表迭代器， 可以双向遍历，同时可以在遍历中修改元素
         */
        ListIterator<String> listIter = c.listIterator();
        while(listIter.hasNext())
            System.out.println(listIter.next());
        /*
            可以反向遍历，与普通迭代器不同
         */
        while(listIter.hasPrevious()){
            System.out.println(listIter.previous());
        }



    }
}
