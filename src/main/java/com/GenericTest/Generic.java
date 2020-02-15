package com.GenericTest;

public class Generic<T> {
    private T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
    public void show(T t){
        System.out.println("show : " + t);
    }

    public<T> void genericShow(T t){
        System.out.println("调用泛型方法，任意类型参数： " + t);
    }
    public<K> void genericShow2(K t){
        System.out.println("调用泛型方法，任意类型参数： " + t);
    }
}
