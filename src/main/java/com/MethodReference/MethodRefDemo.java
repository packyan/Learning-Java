package com.MethodReference;

public class MethodRefDemo {
    public static void main(String[] args){
        convert(new CoverterInter() {
            @Override
            public int converString(String s) {
                return Integer.parseInt(s);
            }
        });

        convert(s -> Integer.parseInt(s));
        convert(Integer::parseInt);

    }
    public static void convert(CoverterInter Cvt){
        int number = Cvt.converString("2324");
        System.out.println(number);
    }
}
