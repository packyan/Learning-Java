package com.CollectionTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class IteratorDemo {
    public static void main(String[] args) {
        ReverseList<String> relist = new ReverseList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            String  str = String.valueOf(random.nextInt(2000));
            System.out.println(str);
            relist.add(str);
        }
        System.out.println("-----------reverse");
        for (var str :
                relist) {
            System.out.println(str);
        }
    }
}
class ReverseList<T> implements Iterable{

    List<T> list = new ArrayList<>();

    public void add(T n){
        list.add(n);
    }
    @Override
    public Iterator iterator() {
        return  new ReverseListIterator(list.size());
    }

    class ReverseListIterator implements Iterator{
        int index;

        public ReverseListIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return this.index > 0;
        }

        @Override
        public Object next() {
            index--;
           return list.get(index);
        }
    }
}
