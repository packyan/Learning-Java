package com.FileStreamTest;

import java.io.*;

public class FileStreamDemo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("file.txt");
        FileWriter fileWriter = new FileWriter("file-FileWriter_test.txt");
        char[] ch = new char[3];
        int len = 0;
        while((len = fileReader.read(ch))!=-1){
            System.out.println(new String(ch,0,len));
            fileWriter.write(ch,0,len);

        }
        fileWriter.write("FileWriter-COPY".toCharArray());


        FileReader fileReader2 = new FileReader("file.txt");
        FileWriter fileWriter2 = new FileWriter("file-FileBufferedWriter_test.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter2);
        char[] chs = new char[5];
        int len2 = 0;
        //普通方法 通过数组来读取数据
//        while((len2 = bufferedReader.read(chs)) != -1){
//            System.out.println(new String(chs,0,len2));
//            bufferedWriter.write(chs,0,len2);
//        }
        //通过读取一行来写数据
        while(true) {
            String s = bufferedReader.readLine();
            if (s == null) break;
            bufferedWriter.write(s.toCharArray());
            bufferedWriter.newLine();
            bufferedWriter.flush();

        }
        bufferedWriter.write("天天就知道玩游戏， BufferedWrited");
        bufferedWriter.flush();

        fileReader.close();
        fileWriter.close();
        fileReader2.close();
        fileWriter2.close();



    }
}
