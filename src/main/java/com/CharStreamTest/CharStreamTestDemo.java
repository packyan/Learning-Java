package com.CharStreamTest;

import java.io.*;
import java.util.Arrays;

/*
        为社么要引入字符流，读写文件，如果有非英文字符，不方便使用。如果可以直接读取字符，则更方便。

        GBK 汉字 2字节
        UTF-8 汉字 3字节


 */
public class CharStreamTestDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("file.txt");
        int b;
        while((b = inputStream.read())!=-1){
            System.out.print((char) b);
        }
        //对于非ASCII码的字符，用字节流不能很好的处理
        String str = "中国";
        byte[] strUtf8 = str.getBytes("UTF-8");
        byte[] strGBK = str.getBytes("GBK");

        System.out.println(strUtf8);
        System.out.println(strGBK);

        System.out.println(Arrays.toString(strUtf8)); // [-28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(strGBK)); //[-42, -48, -71, -6]

        /*
           decode 解码 不同编码的字符串， String 指定解码方式
         */

        System.out.println(new String(strUtf8)); //中国
        System.out.println(new String(strGBK));//�й�
        System.out.println(new String(strGBK, "GBK"));//中国

        /*/
        字符流
        OutputStreamWriter
        InputputStreamWriter
         */
        InputStreamReader inputStreamReader = new InputStreamReader(
                new FileInputStream("file.txt"),"UTF-8"
        );
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new FileOutputStream("file-charStream.txt"),"UTF-8"
        );

        //int ch;
//        while((ch = inputStreamReader.read())!= -1){
//  字符流读数据，分别为： 一次读取字符， 一次读取字符数组
//            outputStreamWriter.write(ch);
//            System.out.print((char) ch);
//        }
        char[] ch = new char [3];
        int len = 0;
        while((len = inputStreamReader.read(ch))!= -1){
            System.out.println(new String(ch,0,len));
            outputStreamWriter.write(ch,0,len);
        }

        char[] chArr = new char[] {'可','是'};
        outputStreamWriter.write(chArr);
        inputStreamReader.close();
        outputStreamWriter.close();

    }
}
