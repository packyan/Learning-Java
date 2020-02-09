package com.ObjectIOStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream ooS = new ObjectOutputStream(new FileOutputStream("src\\com\\ObjectIOStream\\ObjectStreamOutput.txt"));
        Person p1 =  new Person(20,"Lin");
        ooS.writeObject(p1);
        ooS.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\com\\ObjectIOStream\\ObjectStreamOutput.txt"));

        Object p2 = objectInputStream.readObject();
        Person p = (Person) p2;
        System.out.println(p);
        //ObjectInputStream objectInputStream =  new ObjectInputStream();

        List<Integer> myList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            myList.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        getAllChoices(myList,res,new ArrayList<>());

        for (var list :
                res) {
            for (var i :
                    list) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }

        int n = 2;
        int counter = 1;
        while(CounterOne(n) + counter != n){
            counter += CounterOne(n);
            n++;
        }
        System.out.println(n);
        System.out.println(CounterOne(100));


    }

    static <T> void getAllChoices(List<T> list, List<List<T>> res, List<T> tmp){
        if(tmp.size() == list.size()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(tmp.contains(list.get(i)))
                continue;

            tmp.add(list.get(i));
            getAllChoices(list,res,tmp);
            tmp.remove(list.get(i));
        }
    }

    static int CounterOne(int num){
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int number = 0;
        if(numStr != null && len >= 1){
            for (int i = 0; i < len; i++) {
                char ch = numStr.charAt(i);
                if(ch == '1')
                    number++;
            }
        }
        return number;
    }
}
