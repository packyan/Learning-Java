package com.InterfaceDemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.*;

public class CallBackDemo {
    public static void main(String[] args) throws InterruptedException {
        ActionListener actionListener = new myTimer();
        Timer timer = new Timer(1000,actionListener);
        timer.start();
        JOptionPane.showMessageDialog(null,"quit ?");
       String[] strs = new String[] {"132","32","45","12","34343","1234","10000"};
       Arrays.sort(strs, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(strs));
        final Stream<String> stream = Arrays.stream(strs);
        final java.util.List<Integer> collect = stream.map(Integer::parseInt).filter((s) -> s > 100).filter((s) -> s <=10000 && s > 140).collect(Collectors.toList());
        System.out.println(collect);

        String[] strss = new String[] {"1,32","32","asdad","as","asdasfdxz","ssss"};
        Arrays.sort(strss, (s1,s2)->{
            if(s1.length() > s2.length())
                return -1;
            if(s1.length() == s2.length())
                return 0;
            else return 1;
        });
        System.out.println(Arrays.toString(strss));

    }
}
class myTimer implements ActionListener{
    String name;
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("at now : " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}