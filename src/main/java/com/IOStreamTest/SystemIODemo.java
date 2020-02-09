package com.IOStreamTest;

import java.io.*;

public class SystemIODemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        //字节流读取输入
//        int by;
//        while((by = inputStream.read()) != -1){
//            System.out.println((char) by);
//        }

        // 字符流 读取输入,将 输入流转换为字符流
        int by;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        System.out.println("input a char");
        by = inputStreamReader.read();
        System.out.println((char) by);
        //  字节流-> 字符流 -> 字符缓冲输入流
        System.out.println("input a string");
        BufferedReader bufferedInputStream = new BufferedReader(inputStreamReader);
        String s = bufferedInputStream.readLine();
        System.out.println(s);

        PrintStream printStream = System.out;
        printStream.println("123");
        printStream.print(213);

        System.out.println("---------------");
        System.out.println("字节打印流");
        PrintStream newprint = new PrintStream("src\\com\\IOStreamTest\\pringStream.txt");
        newprint.write(97);
        //特有方法写数据
        newprint.println("sadasf");
        newprint.print("hello");
        newprint.print("aa");
        newprint.println();
        newprint.print("aa");

        System.out.println("PrintWriter copy 文件");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\com\\IOStreamTest\\pringStream.txt"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\com\\IOStreamTest\\pringStream-copy.txt"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("src\\com\\IOStreamTest\\pringStream-copy.txt"),true);
        String str;
        while((str = bufferedReader.readLine()) != null){
            System.out.println(str);
            printWriter.println(str);
        }
        bufferedReader.close();
        printWriter.close();

    }
}
