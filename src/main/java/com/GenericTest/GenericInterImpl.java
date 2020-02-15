package com.GenericTest;

public class GenericInterImpl<T> implements GenericInterface<T> {
    @Override
    public void showGenericImpl(T o) {
        System.out.println(o);
    }
}
