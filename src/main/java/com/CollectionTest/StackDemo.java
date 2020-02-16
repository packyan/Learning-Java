package com.CollectionTest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class StackDemo {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            stack.push(random.nextInt(20));
        }

        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
}
