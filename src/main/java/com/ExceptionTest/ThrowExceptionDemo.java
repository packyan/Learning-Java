package com.ExceptionTest;

public class ThrowExceptionDemo {
    public static void main(String[] args) {
        for (int i = -1; i <= 1; i+=2) {
           try{
               System.out.println(get(i));
                }
           catch (IllegalArgumentException e){
               e.printStackTrace();
           }
        }
    }

    public static int get(int num) throws IllegalArgumentException {
        if(num < 0){
            throw new IllegalArgumentException("plz input a none negative number");
        }
        else{
            return -num;
        }
    }
}
