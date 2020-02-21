package com.IOTest;

import java.io.*;

public class InputStreamDemoTest {
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream output = null;
        try{
             inputStream = new FileInputStream("IOtest\\file.txt");
             output = new FileOutputStream("IOtest\\file-copy.txt");
             //读入数据
            // 读入一个字节的数据
//            int by = inputStream.read();
//            System.out.println((char) by);
//            by = inputStream.read();
//            System.out.println((char) by);

//            byte[] bytes = new byte[1000];
            //返回实际读取字节的长度
//            inputStream.read(bytes);
//            for(var b : bytes)
//                System.out.println((char) b);
            byte b;
            while((b = (byte) inputStream.read())!= -1){
                output.write(b);
            }

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (inputStream != null && output != null){
                try{
                    inputStream.close();
                    output.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
